package com.example.toolrental.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RentalAgreement implements Serializable {
    @JsonProperty("code")
    private String code;
    @JsonProperty("type")
    private String type;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("rentalDays")
    private int rentalDays;
    @JsonProperty("checkoutDate")
    private LocalDate checkoutDate;
    @JsonProperty("dueDate")
    private LocalDate dueDate;
    @JsonProperty("dailyRentalCharge")
    private BigDecimal dailyRentalCharge;
    @JsonProperty("chargeDays")
    private int chargeDays;
    @JsonProperty("preDiscountCharge")
    private BigDecimal preDiscountCharge;
    @JsonProperty("discountPercentage")
    private int discountPercentage;
    @JsonProperty("discountAmount")
    private BigDecimal discountAmount;
    @JsonProperty("finalCharge")
    private BigDecimal finalCharge;

    public RentalAgreement(String code, String type, String brand,int rentalDays, LocalDate checkoutDate, LocalDate dueDate, BigDecimal dailyRentalCharge, int chargeDays, BigDecimal preDiscountCharge, int discountPercentage, BigDecimal discountAmount, BigDecimal finalCharge) {
        this.code = code;
        this.type = type;
        this.brand = brand;
        this.rentalDays = rentalDays;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.dailyRentalCharge = dailyRentalCharge;
        this.chargeDays = chargeDays;
        this.preDiscountCharge = preDiscountCharge;
        this.discountPercentage = discountPercentage;
        this.discountAmount = discountAmount;
        this.finalCharge = finalCharge;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }
    public BigDecimal getPreDiscountCharge() {
        return preDiscountCharge;
    }

    public void setPreDiscountCharge(BigDecimal preDiscountCharge) {
        this.preDiscountCharge = preDiscountCharge;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getDailyRentalCharge() {
        return dailyRentalCharge;
    }

    public void setDailyRentalCharge(BigDecimal dailyRentalCharge) {
        this.dailyRentalCharge = dailyRentalCharge;
    }

    public int getChargeDays() {
        return chargeDays;
    }

    public void setChargeDays(int chargeDays) {
        this.chargeDays = chargeDays;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getFinalCharge() {
        return finalCharge;
    }

    public void setFinalCharge(BigDecimal finalCharge) {
        this.finalCharge = finalCharge;
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        sb.append("Tool code: ").append(this.code).append("\n").append("Tool type: ").append(this.type).append("\n")
                .append("Brand: ").append(this.brand).append("\n").append("Rental Days: ").append(this.rentalDays).append("\n")
                .append("Daily Rental Charge: ").append("$").append(this.dailyRentalCharge).append("\n")
                .append("Checkout Date: ").append(this.checkoutDate.format(dateTimeFormatter)).append("\n")
                .append("Due Date: ").append(this.dueDate.format(dateTimeFormatter)).append("\n")
                .append("Charge Days: ").append(this.chargeDays).append("\n")
                .append("Pre-discount Charge: ").append("$").append(this.preDiscountCharge.toString()).append("\n")
                .append("Discount Percent: ").append(this.discountPercentage).append("%").append("\n")
                .append("Discount amount: ").append("$").append(this.discountAmount.toString()).append("\n")
                .append("Final Charge: ").append("$").append(this.finalCharge.toString()).append("\n");
        return sb.toString();
    }

}
