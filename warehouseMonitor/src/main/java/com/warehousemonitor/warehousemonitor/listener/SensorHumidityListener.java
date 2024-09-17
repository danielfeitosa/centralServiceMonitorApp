package com.warehousemonitor.warehousemonitor.listener;

import com.warehousemonitor.warehousemonitor.service.CentralMonitoringService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SensorHumidityListener {

    private final CentralMonitoringService centralMonitoringService;

    public SensorHumidityListener(CentralMonitoringService centralMonitoringService) {
        this.centralMonitoringService = centralMonitoringService;
    }

    @RabbitListener(queues = "${humidity.data.queue}")
   public void monitorHumidityData(String sensorDataValue){
     this.centralMonitoringService.processHumidityData(sensorDataValue);
   }
}
