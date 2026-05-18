package com.andres.pharmacy.mapper;

import com.andres.pharmacy.dto.ProductRequest;
import com.andres.pharmacy.dto.ProductResponse;
import com.andres.pharmacy.entity.Product;

public class ProductMapper {

    private ProductMapper() {
    }

    public static Product toEntity(ProductRequest request) {
        return Product.builder()
                .name(request.getName())
                .barcode(request.getBarcode())
                .stock(request.getStock())
                .price(request.getPrice())
                .category(request.getCategory())
                .build();
    }

    public static ProductResponse toResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .barcode(product.getBarcode())
                .stock(product.getStock())
                .price(product.getPrice())
                .category(product.getCategory())
                .build();
    }
}
