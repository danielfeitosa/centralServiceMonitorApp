package com.warehousemonitor.warehousemonitor.service;

import com.warehousemonitor.warehousemonitor.domain.ports.MessageNotification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class WarehouseService {

    private final MessageNotification messageNotification;


    public WarehouseService(RabbitTemplate rabbitTemplate,
            MessageNotification messageNotification) {
        this.messageNotification = messageNotification;
    }


    public Mono<Void> processAndPublish(String sensorData, String queueName) {
        System.out.println("Received sensor data: " + sensorData);
        return Mono.fromRunnable(() ->
                        messageNotification.sendMessage(queueName,sensorData))
                .doOnSuccess(success -> System.out.println("Published sensor data to messageNotification")).then();
    }
}