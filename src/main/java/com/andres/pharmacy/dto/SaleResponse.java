package com.andres.pharmacy.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class SaleResponse {

    private Long id;
    private BigDecimal total;
    private LocalDateTime createdAt;
    private List<SaleDetailResponse> details;
}
