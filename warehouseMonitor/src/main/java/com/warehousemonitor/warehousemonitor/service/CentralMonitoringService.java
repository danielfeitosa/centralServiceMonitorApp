package com.warehousemonitor.warehousemonitor.service;

import com.warehousemonitor.warehousemonitor.util.SensorDataConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
public class CentralMonitoringService {


    private final SensorService sensorThresholds;

    private static final Logger logger = LoggerFactory.getLogger(CentralMonitoringService.class);

    public CentralMonitoringService(SensorService sensorThresholds) {
        this.sensorThresholds = sensorThresholds;
    }


    public void processTemperatureData(String sensorDataValue) {
        try {
            var sensorData = SensorDataConvert.parseFromJson(sensorDataValue);

            if (sensorData.getValue() > sensorThresholds.getTemperatureThreshold()) {
                System.out.format("Warehouse %s ALARM: Temperature exceeds threshold! Value: %f",
                        sensorData.getWarehouseId(), sensorData.getValue());
                logger.warn("Warehouse {}, ALARM: Temperature exceeds threshold! Value: {}",
                        sensorData.getWarehouseId(), sensorData.getValue());
            }
        } catch (Exception e) {
            logger.error("Cannot process Temperature Data", e);
        }
    }


    public void processHumidityData(String sensorDataValue) {
        try {
            var sensorData = SensorDataConvert.parseFromJson(sensorDataValue);

            if (sensorData.getValue() > sensorThresholds.getHumidityThreshold()) {
                System.out.format("Warehouse %s ALARM: Humidity exceeds threshold! Value: %f",
                        sensorData.getWarehouseId(), sensorData.getValue());
                logger.info("Warehouse {}, ALARM: Humidity exceeds threshold! Value: {}",
                        sensorData.getWarehouseId(), sensorData.getValue());

            }
        } catch (Exception e) {
            logger.error("Cannot process Humidity Data", e);
        }
    }



}
