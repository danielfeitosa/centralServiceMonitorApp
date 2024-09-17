package com.warehousemonitor.warehousemonitor.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CentralMonitoringServiceTest {

    @Mock
    private SensorService sensorThresholds;

    @InjectMocks
    private CentralMonitoringService centralMonitoringService;


    @Test
    void testWhenProcessTemperatureDataExceedsThreshold() {
        // Arrange
        when(sensorThresholds.getTemperatureThreshold()).thenReturn(35.0f);
        String sensorDataJson = "{\"sensor_id\":\"h1\",\"value\":40.0,\"warehouse_id\":\"wh1\"}";
        centralMonitoringService.processTemperatureData(sensorDataJson);
        verify(sensorThresholds, times(1)).getTemperatureThreshold();

    }

    @Test
    void testWhenProcessHumidityDataExceedsThreshold() {
        // Arrange
        when(sensorThresholds.getHumidityThreshold()).thenReturn(50.0f);
        String sensorDataJson = "{\"sensor_id\":\"h2\",\"value\":60.0,\"warehouse_id\":\"wh2\"}";

       centralMonitoringService.processHumidityData(sensorDataJson);

        verify(sensorThresholds, times(1)).getHumidityThreshold();
    }


}