package com.example.toolrental.unitTest.util;


import com.example.toolrental.util.PriceUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;

public class PriceUtilTest {

    @Test
    @DisplayName("validate discount amount")
    public void validateDiscountAmountTest(){
        BigDecimal value = PriceUtil.discountAmount(10,new BigDecimal("10.99"));
        Assertions.assertTrue(new BigDecimal("1.10").compareTo(value)==0);
    }

    @Test
    @DisplayName("validate final charge")
    public void validateFinalChargeTest(){
        BigDecimal value = PriceUtil.finalCharge(new BigDecimal("9.99"), new BigDecimal("10.99"));
       Assertions.assertTrue(new BigDecimal("1.00").compareTo(value)==0);
    }

    @Test
    @DisplayName("validate total charge")
    public void validateTotalCharge(){
        BigDecimal value = PriceUtil.totalCharge(5,new BigDecimal("10.99"));
        Assertions.assertTrue(new BigDecimal("54.95").compareTo(value)==0);
    }
}
