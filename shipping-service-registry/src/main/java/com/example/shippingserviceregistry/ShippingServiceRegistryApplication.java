package com.example.shippingserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ShippingServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShippingServiceRegistryApplication.class, args);
	}

}
