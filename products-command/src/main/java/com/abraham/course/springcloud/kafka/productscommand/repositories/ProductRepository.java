package com.abraham.course.springcloud.kafka.productscommand.repositories;

import com.abraham.course.springcloud.kafka.productscommand.entities.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, Long> {
}
