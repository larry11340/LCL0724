package com.example.toolrental.controller;

import com.example.toolrental.dto.CheckoutRequest;
import com.example.toolrental.dto.RentalAgreement;
import com.example.toolrental.exception.ToolRentalException;
import com.example.toolrental.service.ToolRentalService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tool_rental_service")
public class ToolRentalController {

    Logger logger = LoggerFactory.getLogger(ToolRentalController.class);

    private ToolRentalService toolRentalService;

    @Autowired
    public ToolRentalController(ToolRentalService toolRentalService){
        this.toolRentalService = toolRentalService;
    }

    @PostMapping("/v1/checkout")
    public ResponseEntity<RentalAgreement> postCheckout(@Valid @RequestBody CheckoutRequest request) throws ToolRentalException {
        logger.info("Entering postCheckout with code " + request.getCode() );
        RentalAgreement rg = toolRentalService.postCheckout(request.getCode(), request.getRentalDayCount(), request.getDiscountPercent(),request.getCheckoutDate());
        System.out.println(rg.toString());
        return ResponseEntity.ok().body(rg);
    }
}
