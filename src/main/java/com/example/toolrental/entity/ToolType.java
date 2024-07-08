package com.example.toolrental.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "Tool_Type")
public class ToolType {
    @NotNull
    @Id
    private String type;
    @NotNull
    private BigDecimal dailyCharge;
    @NotNull
    private boolean isWeekdayCharge;

    @NotNull
    public boolean isWeekdayCharge() {
        return isWeekdayCharge;
    }

    public void setWeekdayCharge(@NotNull boolean weekdayCharge) {
        isWeekdayCharge = weekdayCharge;
    }

    public @NotNull String getType() {
        return type;
    }

    public void setType(@NotNull String type) {
        this.type = type;
    }

    public @NotNull BigDecimal getDailyCharge() {
        return dailyCharge;
    }

    public void setDailyCharge(@NotNull BigDecimal dailyCharge) {
        this.dailyCharge = dailyCharge;
    }

    @NotNull
    public boolean isWeekendCharge() {
        return isWeekendCharge;
    }

    public void setWeekendCharge(@NotNull boolean weekendCharge) {
        isWeekendCharge = weekendCharge;
    }

    @NotNull
    public boolean isHolidayCharge() {
        return isHolidayCharge;
    }

    public void setHolidayCharge(@NotNull boolean holidayCharge) {
        isHolidayCharge = holidayCharge;
    }

    public ToolType() {
    }

    @NotNull
    private boolean isWeekendCharge;

    public ToolType(String type, BigDecimal dailyCharge, boolean isWeekdayCharge, boolean isWeekendCharge, boolean isHolidayCharge) {
        this.type = type;
        this.dailyCharge = dailyCharge;
        this.isWeekdayCharge = isWeekdayCharge;
        this.isWeekendCharge = isWeekendCharge;
        this.isHolidayCharge = isHolidayCharge;
    }

    @NotNull
    private boolean isHolidayCharge;
}
