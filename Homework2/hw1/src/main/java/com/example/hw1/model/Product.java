package com.example.hw1.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "T_PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    private int id;

    @Column(name = "NAME", length = 20)
    private String name;

    @Column(name = "PRICE")
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SHOP_ID", referencedColumnName = "SHOP_ID")
    private Shop productShop = new Shop();


    @ManyToMany(mappedBy = "products",fetch = FetchType.LAZY)
    private Set<Order> orders = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Shop getProductShop() {
        return productShop;
    }

    public void setProductShop(Shop productShop) {
        this.productShop = productShop;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }


}
