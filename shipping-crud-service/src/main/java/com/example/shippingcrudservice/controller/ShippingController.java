package com.example.shippingcrudservice.controller;

import com.example.shippingcrudservice.model.Invoice;
import com.example.shippingcrudservice.repository.InvoiceRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "/invoices", produces = "application/json")
@RequestMapping("/invoices")
public class ShippingController {

    @Autowired
    InvoiceRepository repository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Invoice> getInvoices() {
        return repository.findAll();
    }

    @ApiOperation(value = "Get an Invoice By Invoice Id", response = Invoice.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Invoice Details Retrieved", response = Invoice.class),
            @ApiResponse(code = 404, message = "Invoice not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Invoice getInvoiceById(@PathVariable int id) {
        return repository.findById(id).get();
    }

    @GetMapping("/customers/{customerId}")
    public List<Invoice> getInvoicesByCustomer(@PathVariable int customerId) {
        return repository.findByCustomerId(customerId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice createInvoice(@RequestBody Invoice invoice) {
        invoice.getInvoiceItems().forEach(invoiceItem -> invoiceItem.setInvoice(invoice));
        return repository.save(invoice);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateInvoice(@RequestBody Invoice invoice) {
        invoice.getInvoiceItems().forEach(invoiceItem -> invoiceItem.setInvoice(invoice));
        repository.save(invoice);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteInvoice(@PathVariable int id) {
        repository.deleteById(id);
    }
}
