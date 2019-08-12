package com.example.shippingedgeservice.feign;

import com.example.shippingedgeservice.model.Invoice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "shipping-crud-service")
public interface ShippingClient {
    @RequestMapping(value = "/invoices", method = RequestMethod.POST)
    Invoice createInvoice(@RequestBody Invoice invoice);
    @RequestMapping(value = "/invoices/customers/{id}", method = RequestMethod.GET)
    List<Invoice> getInvoicesByCustomer(@PathVariable int id);
}
