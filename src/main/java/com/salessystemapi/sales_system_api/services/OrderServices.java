package com.salessystemapi.sales_system_api.services;

import com.salessystemapi.sales_system_api.entities.Order;
import com.salessystemapi.sales_system_api.entities.User;
import com.salessystemapi.sales_system_api.repositories.OrderRepository;
import com.salessystemapi.sales_system_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServices {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }

}
