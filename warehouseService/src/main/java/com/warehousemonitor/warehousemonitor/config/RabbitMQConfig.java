package com.warehousemonitor.warehousemonitor.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String TEMPERATURE_QUEUE = "temperature.data.queue";
    public static final String HUMIDITY_QUEUE = "humidity.data.queue";

    @Bean
    public Queue temperatureQueue() {
        return new Queue(TEMPERATURE_QUEUE, true);
    }

    @Bean
    public Queue humidityQueue() {
        return new Queue(HUMIDITY_QUEUE, true);
    }

    @Bean
    public FanoutExchange createCentralWarehouseMonitorExchange() {
        return ExchangeBuilder.fanoutExchange("central-monitor.ex").build();
    }

    @Bean
    public Binding createTemperatureBinding() {
        return BindingBuilder.bind(temperatureQueue()).
                to(createCentralWarehouseMonitorExchange());
    }

    @Bean
    public Binding createHumityBinding() {
        return BindingBuilder.bind(humidityQueue()).
                to(createCentralWarehouseMonitorExchange());
    }

    @Bean
    public RabbitAdmin createRabbitAdmin(ConnectionFactory connectionFactory) {
        System.out.println("Creating RabbitAdmin bean...");
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> initializeRabbit(RabbitAdmin rabbitAdmin) {
        System.out.println("Initializing RabbitAdmin...");
        return event -> {
            System.out.println("RabbitAdmin initialize called.");
            rabbitAdmin.initialize();
        };
    }
}