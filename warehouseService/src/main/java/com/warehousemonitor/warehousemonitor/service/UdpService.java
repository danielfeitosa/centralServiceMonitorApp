package com.warehousemonitor.warehousemonitor.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import reactor.netty.udp.UdpServer;

import static com.warehousemonitor.warehousemonitor.config.RabbitMQConfig.HUMIDITY_QUEUE;
import static com.warehousemonitor.warehousemonitor.config.RabbitMQConfig.TEMPERATURE_QUEUE;

@Component
public class UdpService {

    private final WarehouseService warehouseService;


    public UdpService(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }


    @PostConstruct
    public void init() {
        startTemperatureReceiver();
        startHumidityReceiver();
    }

    private void startTemperatureReceiver() {
        System.out.println("startTemperatureReceiver");
       UdpServer.create()
                .port(3344)
                .handle((in, out) -> in.receive()
                        .asString()

                        .flatMap(data -> warehouseService.processAndPublish(data,TEMPERATURE_QUEUE))
                        .then())
                .bindNow()
                .onDispose();
    }

    private void startHumidityReceiver() {

        System.out.println("startHumidityReceiver");
        reactor.netty.udp.UdpServer.create()
                .port(3355)
                .handle((in, out) -> in.receive()
                        .asString()
                        .flatMap(data -> warehouseService.processAndPublish(data, HUMIDITY_QUEUE))
                        .then())
                .bindNow()
                .onDispose();
    }
}
