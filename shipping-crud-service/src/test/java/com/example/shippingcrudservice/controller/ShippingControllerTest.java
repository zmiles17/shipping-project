package com.example.shippingcrudservice.controller;

import com.example.shippingcrudservice.repository.InvoiceRepository;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@WebMvcTest(ShippingController.class)
public class ShippingControllerTest {

    @MockBean
    InvoiceRepository repository;

    @Test
    public void getInvoices() {
    }

    @Test
    public void getInvoiceById() {
    }

    @Test
    public void createInvoice() {
    }

    @Test
    public void updateInvoice() {
    }

    @Test
    public void deleteInvoice() {
    }
}