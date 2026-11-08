package com.abraham.course.springcloud.kafka.productscommand.handlers;

import com.abraham.course.springcloud.kafka.productscommand.models.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class ProductCommandConsumer {

    private static final Logger logger = LoggerFactory.getLogger(ProductCommandConsumer.class);

    @Bean
    public Consumer<Command<?>> handleCommand() {
        return command ->
            logger.info("Command received successfully:\n-Type: {} \n-Body: {}\n", command.type(), command.body());
    }

}
