package com.minizone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

import com.minizone.entities.Product;
import com.minizone.exceptions.CartException;
import com.minizone.servicesImplementation.CartServiceImplementation;


@RestController
public class CartController {

    @Autowired
    private CartServiceImplementation cartServiceImpl;
    

    @PostMapping("/addtocart/{cartId}/{productID}")
    public ResponseEntity<String> addToCartHandler(@PathVariable Long cartId, @PathVariable Long productID) throws CartException{
    
        String addToCart = cartServiceImpl.addProductToCart(cartId, productID);
        
        return new ResponseEntity<String>(addToCart,HttpStatus.CREATED);
        
    }
    
    
    @DeleteMapping("/deletefromcart/{cartID}/{productID}")
    public ResponseEntity<String> deleteProductFromCartHandler(@PathVariable Long cartID, @PathVariable Long productID) throws CartException {
    
        String deleteFromCart = cartServiceImpl.deleteProductFromCartById(cartID, productID);
        
        return new ResponseEntity<String>(deleteFromCart, HttpStatus.OK);
    }
    
    @GetMapping("getallproductsfromcart/{cartId}")
    public ResponseEntity<List<Product>> getAllProductsFromCartHandler(@PathVariable Long cartId) throws CartException{
    	
    	List<Product> products = cartServiceImpl.getAllProductsFromCart(cartId);
    	
    	return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    	
    }
    
}






