package com.salessystemapi.sales_system_api.config;

import com.salessystemapi.sales_system_api.entities.User;
import com.salessystemapi.sales_system_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private UserRepository userRepository;
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Alex", "alex@gmail.com",
                "123456", "987412369");
        User u2 = new User(null, "Alane", "alane@gmail.com",
                "78910", "996321478");

        userRepository.saveAll(Arrays.asList(u1, u2));

    }


}
