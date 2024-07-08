package com.example.toolrental.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "Tool_Type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ToolType implements Serializable {
    @NotNull
    @Id
    private String type;
    @NotNull
    private BigDecimal dailyCharge;
    @NotNull
    private boolean isWeekdayCharge;
    @NotNull
    private boolean isWeekendCharge;
    @NotNull
    private boolean isHolidayCharge;
}
