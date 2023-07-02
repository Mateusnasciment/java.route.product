package com.example.springboot.services;


import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<ProductModel>findAll()  {
        return productRepository.findAll();
    }
    public ProductModel findunique (UUID id) {
        return productRepository.findById(id).orElseThrow(() ->new RuntimeException("product not found"));
    }
    public ProductModel save(ProductModel productModel){
        return productRepository.save(productModel);
    }
}
