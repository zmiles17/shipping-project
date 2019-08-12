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
    private InvoiceRepository repository;

    @ApiOperation(value = "Get all Invoices", response = Invoice.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "All Invoices Retrieved"),
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Invoice> getInvoices() {
        return repository.findAll();
    }

    @ApiOperation(value = "Get an Invoice By Invoice Id", response = Invoice.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Invoice Details Retrieved", response = Invoice.class),
            @ApiResponse(code = 404, message = "Invoice not found")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Invoice getInvoiceById(@PathVariable int id) {
        return repository.findById(id).get();
    }

    @ApiOperation(value = "Get all Invoices By Customer ID", response = Invoice.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Invoice Details Retrieved for given Customer"),
            @ApiResponse(code = 404, message = "Customer ID does not exist")
    })
    @GetMapping("/customers/{customerId}")
    public List<Invoice> getInvoicesByCustomer(@PathVariable int customerId) {
        return repository.findByCustomerId(customerId);
    }

    @ApiOperation(value = "Create an Invoice", response = Invoice.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Invoice Created Successfully"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice createInvoice(@RequestBody Invoice invoice) {
        invoice.getInvoiceItems().forEach(invoiceItem -> invoiceItem.setInvoice(invoice));
        return repository.save(invoice);
    }

    @ApiOperation(value = "Update/Overwrite an Invoice")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Invoice Successfully Updated"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateInvoice(@RequestBody Invoice invoice) {
        invoice.getInvoiceItems().forEach(invoiceItem -> invoiceItem.setInvoice(invoice));
        repository.save(invoice);
    }

    @ApiOperation(value = "Delete an Invoice")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Invoice Successfully Deleted"),
            @ApiResponse(code = 404, message = "Invoice not found")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteInvoice(@PathVariable int id) {
        repository.deleteById(id);
    }
}
