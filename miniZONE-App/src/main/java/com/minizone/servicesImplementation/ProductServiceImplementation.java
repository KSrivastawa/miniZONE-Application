package com.minizone.servicesImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minizone.entities.Product;
import com.minizone.exceptions.ProductException;
import com.minizone.repositories.ProductRepository;
import com.minizone.services.ProductService;

@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public String addProduct(Product product) throws ProductException {

        Product addProduct = productRepository.findProductByName(product.getProductName());

        if(addProduct == null) {

            productRepository.save(product);

            return "Product added!";
        }
        else {
            throw new ProductException("Not added, Product already exists on the same name!");
        }

    }

    @Override
    public String updateProduct(Product product, Long productId) throws ProductException {
        String message = "Not Updated!";

        Product updateProduct = productRepository.findById(productId).orElseThrow(()-> new ProductException("Product not found!"));

        if(updateProduct != null) {

            productRepository.save(product);

            message = "Product updated successfully!";
        }

        return message;

    }
    @Override
    public String deleteProductById(Long productID) throws ProductException {
        String message = "Not Deleted!";

        Product product = productRepository.findById(productID).orElseThrow(()-> new ProductException("Product not found!"));

        if(product != null) {

            productRepository.delete(product);

            message = "Product deleted successfully!";
        }

        return message;
    }

    @Override
    public Product getProductById(Long productID) throws ProductException {

        Product product = productRepository.findById(productID).orElseThrow(()-> new ProductException("Product not found!"));

        return product;
    }

    @Override
    public List<Product> getAllProducts() throws ProductException {

        List<Product> products = productRepository.findAll();

        if(products.isEmpty()) {
            throw new ProductException("Products is Empty!");
        }

        return products;
    }

}
    