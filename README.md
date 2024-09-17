# CentralServiceMonitorApp


CentralServiceMonitorApp is a reactive system designed to collect data from various sensors in a warehouse environment and transmit the measurements to a central monitoring service. The system monitors temperature and humidity levels and raises alarms when these measurements exceed configured thresholds. Communication between services is managed using RabbitMQ, while sensors use UDP to transmit data.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [System Architecture](#system-architecture)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Warehouse Service**: Collects data from various sensors (temperature and humidity) and sends it to the central monitoring service.
- **Central Monitoring Service**: Configured with thresholds for temperature and humidity. Raises an alarm when the measurements cross these thresholds.
- **Communication**: Uses UDP for sensor data transmission and RabbitMQ for messaging between microservices.
- **Threshold Monitoring**: Configurable thresholds for temperature and humidity monitoring.

## Technologies Used

- Java
- Spring Boot
- Spring WebFlux (Reactive Programming)
- RabbitMQ (for messaging)
- UDP (for sensor data communication)
- Docker (for containerization)
- Maven (for dependency management)

## System Architecture

- **Warehouse Service**: Listens for UDP messages from sensors and sends data to RabbitMQ.
- **Central Monitoring Service**: Consumes messages from RabbitMQ, processes the sensor data, and raises alarms if thresholds are exceeded.
- **Sensors**: Simulated to send temperature and humidity data using UDP.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.8+
- Docker (optional, for running RabbitMQ)
- RabbitMQ instance (local or remote)

### Installation

1. ./run.sh
