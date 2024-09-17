package com.warehousemonitor.warehousemonitor.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehousemonitor.warehousemonitor.domain.SensorData;

public class SensorDataConvert {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static SensorData parseFromJson(String json) throws Exception {
        return objectMapper.readValue(json, SensorData.class);
    }


}
