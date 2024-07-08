package com.example.toolrental.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Table(name = "Tool")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tool implements Serializable {
    @NotNull
    @Id
    private String code;

    @NotNull
    @OneToOne
    @JoinColumn(name="toolType",referencedColumnName = "type")
    private ToolType toolType;
    @NotNull
    private String brand;
}
