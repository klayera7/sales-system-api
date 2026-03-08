package com.salessystemapi.sales_system_api.repositories;

import com.salessystemapi.sales_system_api.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
