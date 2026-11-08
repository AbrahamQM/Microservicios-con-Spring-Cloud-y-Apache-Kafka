package com.abraham.course.springcloud.kafka.productsapi.services;

import com.abraham.course.springcloud.kafka.productsapi.models.Command;
import com.abraham.course.springcloud.kafka.productsapi.models.dto.ProductDto;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class ProductCommandServiceImpl implements ProductCommandService {
    private final StreamBridge bridge;

    public ProductCommandServiceImpl(StreamBridge bridge) {
        this.bridge = bridge;
    }

    @Override
    public void sendCreate(ProductDto productDto) {
        Command<ProductDto> command = new Command<>("create", null, productDto);
        boolean sent = bridge.send("command-out-0", command); //aquí se define el nombre del binding,
        // ver definición en  application.properties

        if(!sent){
            throw new IllegalStateException("No se envió el comando a kafka");
        }
    }
}
