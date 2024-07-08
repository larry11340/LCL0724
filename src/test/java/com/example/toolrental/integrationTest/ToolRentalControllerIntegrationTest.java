package com.example.toolrental.integrationTest;

import com.example.toolrental.controller.ToolRentalController;
import com.example.toolrental.dto.CheckoutRequest;
import com.example.toolrental.requestHelper.RequestHelper;
import org.hibernate.annotations.processing.SQL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;

import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_CLASS;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureWebTestClient
@TestPropertySource(
        locations = "classpath:application-test.properties")
@ActiveProfiles("test")
@Sql(value = "classpath:/data-test.sql", executionPhase = BEFORE_TEST_CLASS )
public class ToolRentalControllerIntegrationTest {

    @Autowired
    private ToolRentalController toolRentalController;

    @Autowired
    private WebTestClient client;

    private RequestHelper requestHelper;

    @BeforeEach
    public void init(){
        requestHelper = new RequestHelper();
    }

    @Test
    @DisplayName("Test 1")
    public void validateTest1() throws Exception {
        CheckoutRequest cr = requestHelper.getCR1();
        client.post().uri("/tool_rental_service/checkout").contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(cr)).exchange()
                .expectStatus().isBadRequest().expectBody().jsonPath("statusName").isEqualTo("BAD_REQUEST").jsonPath("$.fieldCode.discountPercent").isEqualTo("discountPercent cannot be greater than 100");

    }

    @Test
    @DisplayName("Test 2")
    public void validateTest2() throws Exception {
        CheckoutRequest cr = requestHelper.getCR2();
        client.post().uri("/tool_rental_service/checkout").contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(cr)).exchange()
                .expectStatus().isOk().expectBody().jsonPath("code").isEqualTo("LADW").jsonPath("type").isEqualTo("Ladder")
                .jsonPath("brand").isEqualTo("Werner").jsonPath("rentalDays").isEqualTo(3)
                .jsonPath("checkoutDate").isEqualTo("07/02/20").jsonPath("dueDate").isEqualTo("07/05/20")
                .jsonPath("dailyRentalCharge").isEqualTo(BigDecimal.valueOf(1.99)).jsonPath("chargeDays").isEqualTo(2)
                .jsonPath("preDiscountCharge").isEqualTo(BigDecimal.valueOf(3.98)).jsonPath("discountPercentage").isEqualTo(10)
                .jsonPath("discountAmount").isEqualTo(BigDecimal.valueOf(0.40)).jsonPath("finalCharge").isEqualTo(BigDecimal.valueOf(3.58));
    }
    @Test
    @DisplayName("Test 3")
    public void validateTest3() throws Exception {
        CheckoutRequest cr = requestHelper.getCR3();
        client.post().uri("/tool_rental_service/checkout").contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(cr)).exchange()
                .expectStatus().isOk().expectBody().jsonPath("code").isEqualTo("CHNS").jsonPath("type").isEqualTo("Chainsaw")
                .jsonPath("brand").isEqualTo("Stihl").jsonPath("rentalDays").isEqualTo(5)
                .jsonPath("checkoutDate").isEqualTo("07/02/15").jsonPath("dueDate").isEqualTo("07/07/15")
                .jsonPath("dailyRentalCharge").isEqualTo(BigDecimal.valueOf(1.49)).jsonPath("chargeDays").isEqualTo(3)
                .jsonPath("preDiscountCharge").isEqualTo(BigDecimal.valueOf(4.47)).jsonPath("discountPercentage").isEqualTo(25)
                .jsonPath("discountAmount").isEqualTo(BigDecimal.valueOf(1.12)).jsonPath("finalCharge").isEqualTo(BigDecimal.valueOf(3.35));
    }

    @Test
    @DisplayName("Test 4")
    public void validateTest4() throws Exception {
        CheckoutRequest cr = requestHelper.getCR4();
        client.post().uri("/tool_rental_service/checkout").contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(cr)).exchange()
                .expectStatus().isOk().expectBody().jsonPath("code").isEqualTo("JAKD").jsonPath("type").isEqualTo("Jackhammer")
                .jsonPath("brand").isEqualTo("DeWalt").jsonPath("rentalDays").isEqualTo(6)
                .jsonPath("checkoutDate").isEqualTo("09/03/15").jsonPath("dueDate").isEqualTo("09/09/15")
                .jsonPath("dailyRentalCharge").isEqualTo(BigDecimal.valueOf(2.99)).jsonPath("chargeDays").isEqualTo(3)
                .jsonPath("preDiscountCharge").isEqualTo(BigDecimal.valueOf(8.97)).jsonPath("discountPercentage").isEqualTo(0)
                .jsonPath("discountAmount").isEqualTo(BigDecimal.valueOf(0)).jsonPath("finalCharge").isEqualTo(BigDecimal.valueOf(8.97));
    }

    @Test
    @DisplayName("Test 5")
    public void validateTest5() throws Exception {
        CheckoutRequest cr = requestHelper.getCR5();
        client.post().uri("/tool_rental_service/checkout").contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(cr)).exchange()
                .expectStatus().isOk().expectBody().jsonPath("code").isEqualTo("JAKR").jsonPath("type").isEqualTo("Jackhammer")
                .jsonPath("brand").isEqualTo("Ridgid").jsonPath("rentalDays").isEqualTo(9)
                .jsonPath("checkoutDate").isEqualTo("07/02/15").jsonPath("dueDate").isEqualTo("07/11/15")
                .jsonPath("dailyRentalCharge").isEqualTo(BigDecimal.valueOf(2.99)).jsonPath("chargeDays").isEqualTo(6)
                .jsonPath("preDiscountCharge").isEqualTo(BigDecimal.valueOf(17.94)).jsonPath("discountPercentage").isEqualTo(0)
                .jsonPath("discountAmount").isEqualTo(BigDecimal.valueOf(0)).jsonPath("finalCharge").isEqualTo(BigDecimal.valueOf(17.94));
    }

    @Test
    @DisplayName("Test 6")
    public void validateTest6() throws Exception {
        CheckoutRequest cr = requestHelper.getCR6();
        client.post().uri("/tool_rental_service/checkout").contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(cr)).exchange()
                .expectStatus().isOk().expectBody().jsonPath("code").isEqualTo("JAKR").jsonPath("type").isEqualTo("Jackhammer")
                .jsonPath("brand").isEqualTo("Ridgid").jsonPath("rentalDays").isEqualTo(4)
                .jsonPath("checkoutDate").isEqualTo("07/02/20").jsonPath("dueDate").isEqualTo("07/06/20")
                .jsonPath("dailyRentalCharge").isEqualTo(BigDecimal.valueOf(2.99)).jsonPath("chargeDays").isEqualTo(1)
                .jsonPath("preDiscountCharge").isEqualTo(BigDecimal.valueOf(2.99)).jsonPath("discountPercentage").isEqualTo(50)
                .jsonPath("discountAmount").isEqualTo(BigDecimal.valueOf(1.5)).jsonPath("finalCharge").isEqualTo(BigDecimal.valueOf(1.49));
    }
}
