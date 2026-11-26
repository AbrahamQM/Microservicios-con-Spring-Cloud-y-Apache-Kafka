package com.abraham.course.springcloud.kafka.productscommand.services;

import com.abraham.course.springcloud.kafka.productscommand.models.dto.ProductDto;

public interface ProductService {
    ProductDto create(ProductDto dto);
}
