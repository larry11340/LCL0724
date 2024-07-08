package com.example.toolrental.util;

import java.math.BigDecimal;

public class PriceUtil {

    public static BigDecimal discountAmount(int discountPercentage, BigDecimal totalCharge){
        BigDecimal discounPercentage = BigDecimal.valueOf(discountPercentage);
        BigDecimal discountAmount = (totalCharge.multiply(discounPercentage).divide(BigDecimal.valueOf(100)));
       return discountAmount.setScale(2,BigDecimal.ROUND_HALF_UP);
    }
    public static BigDecimal finalCharge(BigDecimal discountAmount, BigDecimal totalCharge){
        return totalCharge.subtract(discountAmount);
    }
    public static BigDecimal totalCharge(int totalChargeDay, BigDecimal price){
        BigDecimal totalChargeDayBigDecimal = BigDecimal.valueOf(totalChargeDay);
        return price.multiply(totalChargeDayBigDecimal).setScale(2,BigDecimal.ROUND_HALF_UP);
    }
}
