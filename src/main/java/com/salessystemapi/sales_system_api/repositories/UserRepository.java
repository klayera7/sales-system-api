package com.salessystemapi.sales_system_api.repositories;

import com.salessystemapi.sales_system_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
