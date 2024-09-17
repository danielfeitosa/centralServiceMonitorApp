# Central Service Monitor App


CentralServiceMonitorApp is a reactive system designed to collect data from various sensors in a warehouse environment and transmit the measurements to a central monitoring service. The system monitors temperature and humidity levels and raises alarms when these measurements exceed configured thresholds. Communication between services is managed using RabbitMQ, while sensors use UDP to transmit data.

## Table of Contents

- [Features](#features)
- [System Architecture](#system-architecture)
- [Configuration](#configuration)

## Features

- **Warehouse Service**: Collects data from various sensors (temperature and humidity) and sends it to the central monitoring service.
- **Central Monitoring Service**: Configured with thresholds for temperature and humidity. Raises an alarm when the measurements cross these thresholds.
- **Communication**: Uses UDP for sensor data transmission and RabbitMQ for messaging between microservices.
- **Threshold Monitoring**: Configurable thresholds for temperature and humidity monitoring.


## System Architecture

- **Warehouse Service**: Listens for UDP messages from sensors and sends data to RabbitMQ.
- **Central Monitoring Service**: Consumes messages from RabbitMQ, processes the sensor data, and raises alarms if thresholds are exceeded.
- **Sensors**: Simulated to send temperature and humidity data using UDP.




### Installation

- 1. ./run.sh
