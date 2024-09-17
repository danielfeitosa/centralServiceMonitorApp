package com.warehousemonitor.warehousemonitor.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SensorService {

    @Value("${sensor.temperature.threshold}")
    private float temperatureThreshold;

    @Value("${sensor.humidity.threshold}")
    private float humidityThreshold;

    public float getTemperatureThreshold() {
        return temperatureThreshold;
    }

    public float getHumidityThreshold() {
        return humidityThreshold;
    }


}