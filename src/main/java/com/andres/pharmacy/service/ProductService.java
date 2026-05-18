package com.andres.pharmacy.service;

import com.andres.pharmacy.dto.ProductRequest;
import com.andres.pharmacy.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse createProduct(ProductRequest request);

    List<ProductResponse> getAllProducts();

    ProductResponse getProductById(Long id);
}
