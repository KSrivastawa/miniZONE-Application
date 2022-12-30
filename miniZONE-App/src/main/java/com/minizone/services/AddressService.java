package com.minizone.services;

import java.util.List;

import com.minizone.entities.Address;
import com.miniproject.exception.AddressException;
import com.miniproject.exception.UserException;

public interface AddressService {

    public String addAddress(Address address, Long userId) throws AddressException, UserException;
    
    public String updateAddress(Address address, Long userID) throws AddressException, UserException;
    
    public String deleteAddressById(Long userID, Long addresID) throws AddressException, UserException;
    
    public Address getAddressById(Long addressID) throws AddressException;
    
    public List<Address> getAllAddresses() throws AddressException;
    
}