package com.minizone.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.minizone.entities.Address;
import com.minizone.exceptions.AddressException;
import com.minizone.exceptions.UserException;
import com.minizone.servicesImplementation.AddressServiceImplementation;


@RestController
public class AddressController {

	@Autowired
	private AddressServiceImplementation addressServiceImpl;
	
	
	@PostMapping("/addaddress/{userId}")
	public ResponseEntity<String> addAddressHandler(@Valid @RequestBody Address address, @PathVariable Long userId)throws AddressException, UserException{
		
		String message = addressServiceImpl.addAddress(address, userId);
		
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/updateaddress/{userID}")
	public ResponseEntity<String> updateAdressHandler(@RequestBody Address address, @PathVariable Long userID) throws AddressException, UserException{
		
		String message = addressServiceImpl.updateAddress(address, userID);
		
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
		
	}
	
	
	@DeleteMapping("/deleteaddress/{userID}/{addressID}")
	public ResponseEntity<String> deleteAddressByIdHandler(@PathVariable Long userID, @PathVariable Long addressID) throws AddressException, UserException {
		
		String message = addressServiceImpl.deleteAddressById(userID,addressID);
		
		return new ResponseEntity<String>(message, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/getaddress/{addressID}")
	public ResponseEntity<Address> getAddressByIdHandler(@PathVariable Long addressID) throws AddressException{
	
		Address address = addressServiceImpl.getAddressById(addressID);
		
		return new ResponseEntity<Address>(address, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/getalladdresses")
	public ResponseEntity<List<Address>> getAllAddressHandler() throws AddressException{
		
		List<Address> addresses = addressServiceImpl.getAllAddresses();
		
		return new ResponseEntity<List<Address>>(addresses, HttpStatus.OK);
		
	}
	
	
}

