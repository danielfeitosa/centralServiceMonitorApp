package com.warehousemonitor.warehousemonitor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Mono;
import reactor.netty.udp.UdpClient;

@SpringBootApplication
public class WarehouseServiceApplication  {

	public static void main(String[] args) {
		SpringApplication.run(WarehouseServiceApplication.class, args);
	}




}
