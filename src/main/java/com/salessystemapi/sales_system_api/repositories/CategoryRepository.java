package com.salessystemapi.sales_system_api.repositories;

import com.salessystemapi.sales_system_api.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
