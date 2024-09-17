package com.warehousemonitor.warehousemonitor.listener;

import com.warehousemonitor.warehousemonitor.service.CentralMonitoringService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class SensorHumidityListenerTest {

    @Mock
    private CentralMonitoringService centralMonitoringService;

    @InjectMocks
    private SensorHumidityListener sensorHumidityListener;


    @Test
    void testMonitorHumidityData() {
        // Arrange
        String sensorDataValue = "{\"sensor_id\":\"h1\",\"value\":60.0,\"warehouse_id\":\"wh1\"}";

        // Act
        sensorHumidityListener.monitorHumidityData(sensorDataValue);

        // Assert
        verify(centralMonitoringService, times(1)).processHumidityData(sensorDataValue);
    }
}