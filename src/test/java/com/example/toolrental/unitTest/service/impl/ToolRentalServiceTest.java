package com.example.toolrental.unitTest.service.impl;


import com.example.toolrental.dto.RentalAgreement;
import com.example.toolrental.entity.Tool;
import com.example.toolrental.entity.ToolType;
import com.example.toolrental.exception.ToolRentalException;
import com.example.toolrental.repository.ToolRepository;
import com.example.toolrental.service.impl.ToolRentalServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.willAnswer;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class ToolRentalServiceTest {

    @Mock
    private ToolRepository toolRepository;

    private ToolRentalServiceImpl rentalToolService;

    private Optional<Tool> tool;
    @BeforeEach
    public void init(){
        rentalToolService = new ToolRentalServiceImpl(toolRepository);
        ToolType type = new ToolType("Chainsaw",new BigDecimal("1.49"),true, false,true);
        tool = Optional.of(new Tool("CHNS", type, "Stihl"));
    }

    @Test
    @DisplayName("Generate rental Agreement happy path POST /checkout")
    public void validateGeneratedRentalAgreement() throws ToolRentalException {
        doReturn(this.tool).when(this.toolRepository).getToolByCode(any());
        RentalAgreement agreement = rentalToolService.postCheckout("CHNS",5,10, LocalDate.of(2024,7,1));
        RentalAgreement expectedAgreement = new RentalAgreement("CHNS","Chainsaw","Stihl",5,LocalDate.of(2024,7,1),
                LocalDate.of(2024,7,6),new BigDecimal("1.49"),5,new BigDecimal("7.45"),10,new BigDecimal("0.75"), new BigDecimal("6.70"));
        assertTrue(new ReflectionEquals(expectedAgreement).matches(agreement));

    }

    @Test
    @DisplayName("Generate RentalToolException when database is down")
    public void validateRentalToolExceptionWhenDBisDown() throws ToolRentalException {
        willAnswer( invocation -> { throw new ConnectException("database down"); }).given(this.toolRepository).getToolByCode(any());
        Exception rentalToolException = assertThrows(ToolRentalException.class, () -> {
            rentalToolService.postCheckout("CHNS",5,10, LocalDate.of(2024,7,1));;
        });
        String expectedMessage = "Something wrong with database";
        String actualMessage = rentalToolException.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Generate RentalToolException when code is not available")
    public void validateRentalToolExceptionWhenCodeNotFound() throws ToolRentalException {
        Optional<Tool> isEmptyTool = Optional.empty();
        doReturn(isEmptyTool).when(this.toolRepository).getToolByCode(any());

        Exception rentalToolException = assertThrows(ToolRentalException.class, () -> {
            rentalToolService.postCheckout("CHNS",5,10, LocalDate.of(2024,7,1));;
        });
        String expectedMessage = "The code CHNS not found in db";
        String actualMessage = rentalToolException.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
