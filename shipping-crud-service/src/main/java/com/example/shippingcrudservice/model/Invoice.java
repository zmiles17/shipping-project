package com.example.shippingcrudservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "invoice")
public class Invoice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "invoice_id", nullable = false, unique = true, updatable = false, columnDefinition = "int(11) auto_increment")
    private Integer invoiceId;
    @Column(name = "customer_id", nullable = false, precision = 11)
    private Integer customerId;
    @Column(name = "shipto_zip", nullable = false, columnDefinition = "char(5)")
    private String shipToZip;
    @Column(name = "purchase_date", nullable = false, columnDefinition = "date")
    private LocalDate purchaseDate;
    @Column(name = "total_cost", nullable = false, columnDefinition = "decimal(7,2)")
    private Double totalCost;
    @Column(name = "sales_tax", nullable = false, columnDefinition = "decimal(7,2)")
    private Double salesTax;
    @Column(name = "surcharge", nullable = false, columnDefinition = "decimal(7,2)")
    private Double surcharge;
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<InvoiceItem> invoiceItems = new HashSet<>();

    public Invoice() {
        super();
    }

    public Invoice(Integer customerId, String shipToZip, LocalDate purchaseDate, Double totalCost, Double salesTax, Double surcharge, Set<InvoiceItem> invoiceItems) {
        this.customerId = customerId;
        this.shipToZip = shipToZip;
        this.purchaseDate = purchaseDate;
        this.totalCost = totalCost;
        this.salesTax = salesTax;
        this.surcharge = surcharge;
        this.invoiceItems = invoiceItems;
    }

    public Invoice(Integer invoiceId, Integer customerId, String shipToZip, LocalDate purchaseDate, Double totalCost, Double salesTax, Double surcharge, Set<InvoiceItem> invoiceItems) {
        this.invoiceId = invoiceId;
        this.customerId = customerId;
        this.shipToZip = shipToZip;
        this.purchaseDate = purchaseDate;
        this.totalCost = totalCost;
        this.salesTax = salesTax;
        this.surcharge = surcharge;
        this.invoiceItems = invoiceItems;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getShipToZip() {
        return shipToZip;
    }

    public void setShipToZip(String shipToZip) {
        this.shipToZip = shipToZip;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(Double salesTax) {
        this.salesTax = salesTax;
    }

    public Double getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(Double surcharge) {
        this.surcharge = surcharge;
    }

    public Set<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(Set<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return invoiceId.equals(invoice.invoiceId) &&
                customerId.equals(invoice.customerId) &&
                shipToZip.equals(invoice.shipToZip) &&
                purchaseDate.equals(invoice.purchaseDate) &&
                totalCost.equals(invoice.totalCost) &&
                salesTax.equals(invoice.salesTax) &&
                surcharge.equals(invoice.surcharge) &&
                Objects.equals(invoiceItems, invoice.invoiceItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, customerId, shipToZip, purchaseDate, totalCost, salesTax, surcharge, invoiceItems);
    }
}
