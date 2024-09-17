package com.warehousemonitor.warehousemonitor.listener;

import com.warehousemonitor.warehousemonitor.service.CentralMonitoringService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class SensorTemperatureListenerTest {

    @Mock
    private CentralMonitoringService centralMonitoringService;

    @InjectMocks
    private SensorTemperatureListener sensorTemperatureListener;



    @Test
    void testMonitorTemperatureData() {
        // Arrange
        String sensorDataValue = "{\"sensor_id\":\"t1\",\"value\":75.0,\"warehouse_id\":\"wh1\"}";

        // Act
        sensorTemperatureListener.monitorTemperatureData(sensorDataValue);

        // Assert
        verify(centralMonitoringService, times(1)).processTemperatureData(sensorDataValue);
    }
}
