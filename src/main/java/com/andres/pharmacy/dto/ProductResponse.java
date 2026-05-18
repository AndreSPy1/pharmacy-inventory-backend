package com.andres.pharmacy.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductResponse {

    private Long id;

    private String name;

    private String barcode;

    private Integer stock;

    private BigDecimal price;

    private String category;
}
