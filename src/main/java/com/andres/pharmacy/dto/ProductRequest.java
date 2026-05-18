package com.andres.pharmacy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String barcode;

    @NotNull
    private Integer stock;

    @NotNull
    private BigDecimal price;

    @NotBlank
    private String category;
}
