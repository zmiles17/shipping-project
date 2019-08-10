package com.example.shippingedgeservice.service;

import com.example.shippingedgeservice.feign.ShippingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdgeServiceLayer {

    @Autowired
    ShippingClient client;
}
