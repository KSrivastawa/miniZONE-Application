package com.minizone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minizone.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
    
    
}
