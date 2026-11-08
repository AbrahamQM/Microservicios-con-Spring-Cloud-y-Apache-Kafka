package com.abraham.course.springcloud.kafka.productsapi.services;

import com.abraham.course.springcloud.kafka.productsapi.models.dto.ProductDto;

public interface ProductCommandService {
    void sendCreate(ProductDto productDto);
}
