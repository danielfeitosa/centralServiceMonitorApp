package com.warehousemonitor.warehousemonitor.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SensorData {
    @JsonProperty("sensor_id")
    private String sensorId;

    @JsonProperty("value")
    private float value;

    @JsonProperty("warehouse_id")
    private String warehouseId;

    // Constructors
    public SensorData() {
    }

    public SensorData(String sensorId, float value, String warehouseId) {
        this.sensorId = sensorId;
        this.value = value;
        this.warehouseId = warehouseId;
    }

    // Getters and Setters
    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "sensorId='" + sensorId + '\'' +
                ", value=" + value +
                ", warehouseId='" + warehouseId + '\'' +
                '}';
    }
}