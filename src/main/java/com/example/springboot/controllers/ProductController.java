package com.example.springboot.controllers;

import com.example.springboot.dtos.ProductRecordDto;
import com.example.springboot.models.ProductModel;
import com.example.springboot.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService   productService;


    @PostMapping
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return  ResponseEntity.status(HttpStatus.CREATED).body(productService.save(productModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> findone(@PathVariable UUID id) {
        return ResponseEntity.ok(productService.findunique(id));
    }
    @GetMapping("/")
    public ResponseEntity<List<ProductModel>> findall() {
        return ResponseEntity.ok(productService.findAll());
    }
}
