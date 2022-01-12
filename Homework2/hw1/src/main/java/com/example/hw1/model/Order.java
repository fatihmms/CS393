package com.example.hw1.model;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "T_ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE")
    private Date date;

    @Column(name = "AMOUNT")
    private double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMERS_ID", referencedColumnName = "CUSTOMER_ID")
    private Customer customer = new Customer();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "REL_ORDER_PRODUCT",
            joinColumns = @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    )
    private Set<Product> products = new HashSet<>();

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
