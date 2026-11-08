package com.abraham.course.springcloud.kafka.productscommand.models;

public record Command<T>(String type, Long id, T body) {
}
