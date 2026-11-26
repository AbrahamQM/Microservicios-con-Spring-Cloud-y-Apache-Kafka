package com.abraham.course.springcloud.kafka.productscommand.handlers;

import com.abraham.course.springcloud.kafka.productscommand.models.Command;
import com.abraham.course.springcloud.kafka.productscommand.models.dto.ProductDto;
import com.abraham.course.springcloud.kafka.productscommand.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class ProductCommandConsumer {

    private static final Logger logger = LoggerFactory.getLogger(ProductCommandConsumer.class);
    private final ProductService productService;

    public ProductCommandConsumer(ProductService productService) {
        this.productService = productService;
    }

    //se define que este método va a recibir los mensajes del topic
    // en el application.properties.
    @Bean
    public Consumer<Command<?>> handleCommand() {
        return command -> {
            String type = command.type() == null ? "" : command.type().toUpperCase();
            logger.info("Command received successfully:\n-Type: {} \n-Body: {}\n", type, command.body());
            switch (type) {
                case "CREATE" -> {
                    if(command.body() == null){
                        logger.warn("Create Product command received with null body");
                        return;
                    }
                    ProductDto productDto = command.body() instanceof ProductDto ? (ProductDto) command.body() : null;
                    logger.info("Create Product command received: name={} price={}",
                            productDto != null ? productDto.name() : "Unknown",
                            productDto != null ? productDto.price() : "Unknown");

                    productService.create(productDto);
                }

                case "UPDATE" -> logger.info("Update Product command received: {}", command.body());
                case "DELETE" -> logger.info("Delete Product command received: {}", command.body());
                case "READ_ALL" -> logger.info("Read all Products command received: {}", command.body());
                case "READ_ONE" -> logger.info("Read Product by id command received: {}", command.body());
                default -> logger.warn("Command type not recognized: {}", type);
            }

        };
    }
}
