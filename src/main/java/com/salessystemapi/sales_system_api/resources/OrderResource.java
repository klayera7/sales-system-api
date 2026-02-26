package com.salessystemapi.sales_system_api.resources;

import com.salessystemapi.sales_system_api.entities.Order;
import com.salessystemapi.sales_system_api.entities.User;
import com.salessystemapi.sales_system_api.services.OrderServices;
import com.salessystemapi.sales_system_api.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "orders")
public class OrderResource {

    @Autowired
    private OrderServices orderServices;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = orderServices.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order obj = orderServices.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
