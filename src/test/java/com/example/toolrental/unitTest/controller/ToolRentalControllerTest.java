package com.example.toolrental.unitTest.controller;

import com.example.toolrental.controller.ToolRentalController;
import com.example.toolrental.dto.CheckoutRequest;
import com.example.toolrental.dto.RentalAgreement;
import com.example.toolrental.exception.ToolRentalException;
import com.example.toolrental.service.ToolRentalService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class ToolRentalControllerTest {

    @Mock
    private ToolRentalService toolRentalService;
    private ToolRentalController toolRentalController;

    @BeforeEach
    public void init(){
        toolRentalController = new ToolRentalController(toolRentalService);
    }

    @Test
    @DisplayName("Validating PostCheckout")
    public void validatePostCheckout() throws ToolRentalException, IOException {
        RentalAgreement agreement = new RentalAgreement("CHNS","Chainsaw","Stihl",5, LocalDate.of(2024,7,1),
                LocalDate.of(2024,7,6),new BigDecimal("1.49"),5,new BigDecimal("7.45"),10,new BigDecimal("0.75"), new BigDecimal("6.70"));
        doReturn(agreement).when(this.toolRentalService).postCheckout("CHNS",5,10,LocalDate.of(2024,7,1));
        toolRentalService.postCheckout("CHNS",5,10, LocalDate.of(2024,7,1));
        CheckoutRequest cq = new CheckoutRequest("CHNS",5,10,LocalDate.of(2024,7,1));
        ResponseEntity<RentalAgreement> re = toolRentalController.postCheckout(cq);
        Assertions.assertTrue(re.getStatusCode().is2xxSuccessful());
    }
}
