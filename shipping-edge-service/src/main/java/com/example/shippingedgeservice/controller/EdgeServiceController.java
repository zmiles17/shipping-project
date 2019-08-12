package com.example.shippingedgeservice.controller;

import com.example.shippingedgeservice.model.Invoice;
import com.example.shippingedgeservice.service.EdgeServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EdgeServiceController {

    @Autowired
    private EdgeServiceLayer service;

    @RequestMapping(value = "/api/shipping/invoice", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Invoice createInvoice(@RequestBody Invoice invoice) {
        return service.addInvoice(invoice);
    }

    @RequestMapping(value = "/api/shipping/customer/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Invoice> getInvoicesByCustomer(@PathVariable int id) {
        return service.getInvoicesByCustomer(id);
    }
}
