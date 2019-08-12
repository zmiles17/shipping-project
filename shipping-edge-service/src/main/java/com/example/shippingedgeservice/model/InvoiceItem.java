package com.example.shippingedgeservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties(value = "invoice")
public class InvoiceItem implements Serializable {
    private Integer invoiceItemId;
    private Invoice invoice;
    private String itemName;
    private String itemDescription;
    private Integer weight;
    private Double shipCost;

    public InvoiceItem() {
        super();
    }

    public InvoiceItem(Integer invoiceItemId, Invoice invoice, String itemName, String itemDescription, Integer weight, Double shipCost) {
        this.invoiceItemId = invoiceItemId;
        this.invoice = invoice;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.weight = weight;
        this.shipCost = shipCost;
    }

    public InvoiceItem(Invoice invoice, String itemName, String itemDescription, Integer weight, Double shipCost) {
        this.invoice = invoice;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.weight = weight;
        this.shipCost = shipCost;
    }

    public Integer getInvoiceItemId() {
        return invoiceItemId;
    }

    public void setInvoiceItemId(Integer invoiceItemId) {
        this.invoiceItemId = invoiceItemId;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Double getShipCost() {
        return shipCost;
    }

    public void setShipCost(Double shipCost) {
        this.shipCost = shipCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceItem that = (InvoiceItem) o;
        return Objects.equals(invoiceItemId, that.invoiceItemId) &&
                Objects.equals(invoice, that.invoice) &&
                Objects.equals(itemName, that.itemName) &&
                Objects.equals(itemDescription, that.itemDescription) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(shipCost, that.shipCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceItemId, invoice, itemName, itemDescription, weight, shipCost);
    }
}
