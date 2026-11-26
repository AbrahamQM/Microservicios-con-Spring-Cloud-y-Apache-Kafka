package com.abraham.course.springcloud.kafka.productscommand.services;

import com.abraham.course.springcloud.kafka.productscommand.entities.Product;
import com.abraham.course.springcloud.kafka.productscommand.models.dto.ProductDto;
import com.abraham.course.springcloud.kafka.productscommand.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public ProductDto create(ProductDto dto) {
        Product product = new Product(dto.name(), dto.price());
        Product productCreated = productRepository.save(product);
        return new ProductDto(productCreated.getId(), productCreated.getName(), productCreated.getPrice());
    }
}
