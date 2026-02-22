package com.salessystemapi.sales_system_api.resources;

import com.salessystemapi.sales_system_api.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Alex", "alex@gmail.com", "12345", "999999999");
        return ResponseEntity.ok().body(u);
    }

}
