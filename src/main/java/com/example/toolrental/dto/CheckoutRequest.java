package com.example.toolrental.dto;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class CheckoutRequest implements Serializable{

    @JsonProperty("code")
    @NotEmpty(message = "Code is required")
    private String code;
    @JsonProperty("rentalDayCount")
    @Min(value=1, message="rentalDay must be greater than 0")
    private int rentalDayCount;

    @JsonProperty("discountPercent")
    @Min(value=0, message ="discountPercent cannot be smaller than 0")
    @Max(value=100, message = "discountPercent cannot be greater than 100")
    private int discountPercent;

    @JsonCreator
    public CheckoutRequest(String code, int rentalDayCount, int discountPercent, LocalDate checkoutDate) {
        this.code = code;
        this.rentalDayCount = rentalDayCount;
        this.discountPercent = discountPercent;
        this.checkoutDate = checkoutDate;
    }

    //Assuming no timezone issue
    @JsonFormat(pattern="MM/dd/yy")
    @JsonProperty("checkoutDate")
    @NotNull(message = "checkoutDate cannot be null")
    private LocalDate checkoutDate;
}
