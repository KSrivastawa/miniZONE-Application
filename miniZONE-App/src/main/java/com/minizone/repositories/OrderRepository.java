package com.minizone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.minizone.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
