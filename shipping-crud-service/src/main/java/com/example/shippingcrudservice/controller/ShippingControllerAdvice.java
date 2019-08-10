package com.example.shippingcrudservice.controller;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

@RestControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class ShippingControllerAdvice {

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<VndErrors> constraintViolation(SQLIntegrityConstraintViolationException e, WebRequest request) {
        VndErrors error= new VndErrors(request.toString(),e.getMessage());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoSuchElementException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<VndErrors> noElementFound(NoSuchElementException e, WebRequest request) {
        VndErrors error= new VndErrors(request.toString(),e.getMessage());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
