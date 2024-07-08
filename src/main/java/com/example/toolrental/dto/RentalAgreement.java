package com.example.toolrental.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
@AllArgsConstructor
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
