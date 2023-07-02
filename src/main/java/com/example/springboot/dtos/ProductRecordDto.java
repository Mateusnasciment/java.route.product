package com.example.springboot.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRecordDto(@NotBlank String name, @NotNull BigDecimal value) {
    @Override
    public String name() {
        return name;
    }

    @Override
    public BigDecimal value() {
        return value;
    }
}
