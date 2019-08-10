package com.example.shippingcrudservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "invoice"})
@Table(name = "invoice_item")
public class InvoiceItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "invoice_item_id", columnDefinition = "int(11) auto_increment", nullable = false, unique = true)
    private Integer invoiceItemId;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "invoice_id", columnDefinition = "int(11)", nullable = false)
    private Invoice invoice;
    @Column(name = "item_name", columnDefinition = "varchar(50)", nullable = false)
    private String itemName;
    @Column(name = "item_description", nullable = false, columnDefinition = "varchar(255)")
    private String itemDescription;
    @Column(name = "weight", nullable = false, columnDefinition = "int(11)")
    private Integer weight;
    @Column(name = "ship_cost", nullable = false, columnDefinition = "decimal(7,2)")
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
        return invoiceItemId.equals(that.invoiceItemId) &&
                itemName.equals(that.itemName) &&
                itemDescription.equals(that.itemDescription) &&
                weight.equals(that.weight) &&
                shipCost.equals(that.shipCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceItemId, itemName, itemDescription, weight, shipCost);
    }
}
