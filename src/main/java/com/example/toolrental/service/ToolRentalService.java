package com.example.toolrental.service;

import com.example.toolrental.dto.RentalAgreement;
import com.example.toolrental.exception.ToolRentalException;

import java.time.LocalDate;

public interface ToolRentalService {
    RentalAgreement postCheckout(String code, int dayCount, int discount, LocalDate startDate) throws ToolRentalException;
}
