package com.warehousemonitor.warehousemonitor.adapters;

import com.warehousemonitor.warehousemonitor.domain.ports.MessageNotification;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class RabbitMessageNotification implements MessageNotification {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMessageNotification(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendMessage(String queue, String message) {
        rabbitTemplate.send(queue, new Message(message.getBytes()));
    }

    @Override
    public void consumeMessages(String queueName, java.util.function.Consumer<String> processor) {
        rabbitTemplate.execute(channel -> {
            channel.basicConsume(queueName, true, (consumerTag, message) -> {
                String sensorData = new String(message.getBody());
                Mono.just(sensorData).doOnNext(processor).subscribe();
            }, consumerTag -> {
            });
            return null;
        });
    }
}
