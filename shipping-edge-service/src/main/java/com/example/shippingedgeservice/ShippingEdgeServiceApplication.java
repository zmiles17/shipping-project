package com.example.shippingedgeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ShippingEdgeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShippingEdgeServiceApplication.class, args);
	}

}
