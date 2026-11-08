package com.abraham.course.springcloud.kafka.productsapi.controllers;

import com.abraham.course.springcloud.kafka.productsapi.models.dto.ProductDto;
import com.abraham.course.springcloud.kafka.productsapi.services.ProductCommandService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductCommandService commandService;

    public ProductController(ProductCommandService commandService) {
        this.commandService = commandService;
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductDto productDto) {
        commandService.sendCreate(productDto);
        return ResponseEntity.ok().body(Map.of("message",
                "Product creation command sent successfully: " + productDto.name()));
    }

}
