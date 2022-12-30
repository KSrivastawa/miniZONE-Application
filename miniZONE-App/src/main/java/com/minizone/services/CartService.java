package com.minizone.services;

import java.util.List;

import com.minizone.entities.Product;
import com.minizone.exceptions.CartException;

public interface CartService {

    public String addProductToCart(Long cartId, Long productID) throws CartException;
    
    public String deleteProductFromCartById(Long cartID, Long productID) throws CartException;

    public List<Product> getAllProductsFromCart(Long cartId) throws CartException;
    
}
