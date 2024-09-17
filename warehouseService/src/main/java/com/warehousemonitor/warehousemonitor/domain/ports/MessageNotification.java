package com.warehousemonitor.warehousemonitor.domain.ports;

public interface MessageNotification {

    void sendMessage(String queue, String message);
    void consumeMessages(String queueName, java.util.function.Consumer<String> processor);

}