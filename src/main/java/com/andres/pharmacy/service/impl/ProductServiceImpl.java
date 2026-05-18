package com.andres.pharmacy.service.impl;

import com.andres.pharmacy.dto.ProductRequest;
import com.andres.pharmacy.dto.ProductResponse;
import com.andres.pharmacy.entity.Product;
import com.andres.pharmacy.mapper.ProductMapper;
import com.andres.pharmacy.repository.ProductRepository;
import com.andres.pharmacy.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponse createProduct(ProductRequest request) {
        if (productRepository.existsByBarcode(request.getBarcode())) {
            throw new IllegalArgumentException("Product barcode already exists");
        }

        Product product = ProductMapper.toEntity(request);
        Product savedProduct = productRepository.save(product);

        return ProductMapper.toResponse(savedProduct);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toResponse)
                .toList();
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        return ProductMapper.toResponse(product);
    }
}
