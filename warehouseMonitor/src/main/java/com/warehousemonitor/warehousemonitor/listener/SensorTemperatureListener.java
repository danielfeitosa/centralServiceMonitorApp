package com.warehousemonitor.warehousemonitor.listener;

import com.warehousemonitor.warehousemonitor.service.CentralMonitoringService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SensorTemperatureListener {

    private final CentralMonitoringService centralMonitoringService;

    public SensorTemperatureListener(CentralMonitoringService centralMonitoringService) {
        this.centralMonitoringService = centralMonitoringService;
    }

    @RabbitListener(queues = "${temperature.data.queue}")
    public void monitorTemperatureData(String data) {
        centralMonitoringService.processTemperatureData(data);
    }


}
