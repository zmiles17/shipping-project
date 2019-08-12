package com.example.shippingedgeservice.service;

import com.example.shippingedgeservice.feign.ShippingClient;
import com.example.shippingedgeservice.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class EdgeServiceLayer {

    @Autowired
    ShippingClient client;

    public Invoice addInvoice(Invoice invoice) {
        invoice.setTotalCost(0.00);
        AtomicInteger weight = new AtomicInteger();
        invoice.setSalesTax(7.2);
        invoice.getInvoiceItems().forEach(invoiceItem -> {
            //calculating shipping cost based on zip code
            switch(invoice.getShipToZip().charAt(0)) {
                case '0':
                case '1':
                case '2':
                    invoiceItem.setShipCost(9.99);
                    break;
                case '3':
                    invoiceItem.setShipCost(14.99);
                    break;
                case '4':
                case '5':
                case '6':
                    invoiceItem.setShipCost(19.99);
                case '7':
                case '8':
                case '9':
                    invoiceItem.setShipCost(24.99);
                    break;
            }
            invoiceItem.setShipCost((double) Math.round(invoiceItem.getShipCost() * 1.072 * 100.0) / 100.0);
            invoice.setTotalCost(invoiceItem.getShipCost() + invoice.getTotalCost());
            weight.addAndGet(invoiceItem.getWeight());
        });
        //calculating surcharge based on cumulative weight
        if(weight.intValue() > 10) {
            invoice.setSurcharge(8.50);
        } else if(weight.intValue() > 17) {
            invoice.setSurcharge(12.50);
        } else if(weight.intValue() > 25) {
            invoice.setSurcharge(19.99);
        } else if(weight.intValue() > 35) {
            invoice.setSurcharge(50.00);
        }
        invoice.setSurcharge((double) Math.round(invoice.getSurcharge() * 1.072 * 100.0) / 100.0);
        invoice.setTotalCost((double) Math.round(invoice.getSurcharge() + invoice.getTotalCost() * 100.0) / 100.0);
        return client.createInvoice(invoice);
    }

    public List<Invoice> getInvoicesByCustomer(int id) {
        return client.getInvoicesByCustomer(id);
    }
}
