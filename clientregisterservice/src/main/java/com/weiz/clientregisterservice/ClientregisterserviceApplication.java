package com.weiz.clientregisterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientregisterserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientregisterserviceApplication.class, args);
	}

}
