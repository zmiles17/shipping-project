package com.example.shippingedgeservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class EdgeControllerAdvice {
}
