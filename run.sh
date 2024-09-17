

#!/bin/bash

# Start Docker Compose
echo "Starting Docker Compose..."
docker-compose up -d

# Wait for Docker containers to be ready
echo "Waiting for Docker services to start..."
sleep 15

# Start the first Spring Boot application (warehouseService)
echo "Starting warehouseService application..."
cd warehouseService
./mvnw clean package
./mvnw spring-boot:run &
cd ..

# Wait a bit to ensure the first application starts
sleep 10

# Start the second Spring Boot application (warehouseMonitor)
echo "Starting warehouseMonitor application..."
cd warehouseMonitor
./mvnw clean package
./mvnw spring-boot:run &
cd ..

# Wait a bit to ensure the applications start
sleep 10
# Print and send 10 UDP calls for temperature data
echo "Sending temperature data:"
for i in {1..10}
do
  data="{\"sensor_id\":\"temp_sensor_$i\",\"value\":$((RANDOM % 100 + 1)),\"warehouse_id\":\"wh_temp_$i\"}"
  echo "$data"
  echo "$data" | nc -u -w1 localhost 3344
done

# Print and send 10 UDP calls for humidity data
echo "Sending humidity data:"
for i in {1..10}
do
  data="{\"sensor_id\":\"humidity_sensor_$i\",\"value\":$((RANDOM % 100 + 1)),\"warehouse_id\":\"wh_humidity_$i\"}"
  echo "$data"
  echo "$data" | nc -u -w1 localhost 3355
done

echo "Script execution completed."
