package com.minizone.services;

import java.util.List;

import com.minizone.entities.Product;
import com.minizone.exceptions.ProductException;

public interface ProductService {
	
	 	public String addProduct(Product product, Long userId) throws ProductException;
	    
	    public String updateProduct(Product product, Long productId, Long userId) throws ProductException;
	    
	    public String deleteProductById(Long productID, Long userId) throws ProductException;
	    
	    public Product getProductById(Long productID) throws ProductException;
	    
	    public List<Product> getAllProducts() throws ProductException;

}
