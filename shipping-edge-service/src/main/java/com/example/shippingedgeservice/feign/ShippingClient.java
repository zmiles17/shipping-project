package com.example.shippingedgeservice.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "shipping-crud-service")
public interface ShippingClient {
}
