package com.minizone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.minizone.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

}