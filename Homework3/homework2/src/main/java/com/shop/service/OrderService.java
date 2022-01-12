package com.shop.service;

import com.shop.dto.OrderDTO;
import com.shop.model.Order;
import com.shop.model.Product;
import com.shop.model.Shop;
import com.shop.repo.CustomerRepository;
import com.shop.repo.OrderRepository;
import com.shop.repo.ProductRepository;
import com.shop.repo.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ShopRepository shopRepository;

    public OrderDTO createOrder(OrderDTO orderDTO){
        List<Product> products = new ArrayList<>();
        Order order = new Order();

        for (int id: orderDTO.getProducts()) {
            Product product = productRepository.getById(id);
            product.getOrders().add(order);
            products.add(product);
            productRepository.save(product);
        }

        order.setAmount(orderDTO.getAmount());
        order.setProducts(products);
        //default customer is Esma Meral
        order.setCustomer(customerRepository.getById(6));
        orderRepository.save(order);
        return orderDTO;
    }
}
