package com.salessystemapi.sales_system_api.repositories;

import com.salessystemapi.sales_system_api.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
