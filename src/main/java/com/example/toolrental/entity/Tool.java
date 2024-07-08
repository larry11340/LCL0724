package com.example.toolrental.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Tool")
public class Tool {
    @NotNull
    @Id
    private String code;

    public Tool() {
    }

    public Tool(String code, ToolType toolType, String brand) {
        this.code = code;
        this.toolType = toolType;
        this.brand = brand;
    }

    public @NotNull ToolType getToolType() {
        return toolType;
    }

    public void setToolType(@NotNull ToolType toolType) {
        this.toolType = toolType;
    }

    public @NotNull String getCode() {
        return code;
    }

    public void setCode(@NotNull String code) {
        this.code = code;
    }

    public @NotNull String getBrand() {
        return brand;
    }

    public void setBrand(@NotNull String brand) {
        this.brand = brand;
    }

    @NotNull
    @OneToOne
    @JoinColumn(name="toolType",referencedColumnName = "type")
    private ToolType toolType;
    @NotNull
    private String brand;
}
