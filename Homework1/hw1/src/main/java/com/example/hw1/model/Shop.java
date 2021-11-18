package com.example.hw1.model;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "T_SHOP")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SHOP_ID")
    private int id;

    @Column(name = "ADDRESS_OF_SHOP")
    private String address_of_shop;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    private Set<Customer> customers = new HashSet<>();

    @OneToMany(mappedBy = "productShop", cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress_of_shop() {
        return address_of_shop;
    }

    public void setAddress_of_shop(String address_of_shop) {
        this.address_of_shop = address_of_shop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
