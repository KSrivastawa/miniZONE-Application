package com.minizone.servicesImplementation;

import com.minizone.entities.*;
import com.minizone.exceptions.OrderException;
import com.minizone.repositories.AddressRepository;
import com.minizone.repositories.OrderRepository;
import com.minizone.repositories.UserRepository;
import com.minizone.services.OrderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



    @Service
    public class OrderServiceImplementation implements OrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;


    @Override
    public String addOrder(Order order, Long addressId, Long userID) throws OrderException {

        String message = "Not Ordered!";

        User user = userRepository.findById(userID).orElseThrow(()-> new OrderException("User not found!"));

        Address address = addressRepository.findById(addressId).orElseThrow(()-> new OrderException("Address not found for this respective user!"));

        if(user != null) {

            if(user.getAddress().get(0) != null) {

                order.setUser(user);
                order.setAddress(address);
                orderRepository.save(order);

                message = "Order Saved Successfully!";

            }else {
                throw new OrderException("Address not found for this respective user!");
            }

        }

        return message;

    }
    @Override
    public String deleteOrderById(Long orderID) throws OrderException {

        String message = "Not Deleted!";

        Order order = orderRepository.findById(orderID).orElseThrow(()-> new OrderException("Order Not Found!"));

        if(order != null) {
            orderRepository.delete(order);
            message = "Order Deleted!";
        }

        return message;

    }

    @Override
    public Order getOrderById(Long orderID) throws OrderException {

        Order order = orderRepository.findById(orderID).orElseThrow(()-> new OrderException("Order Not Found!"));

        return order;
    }

    @Override
    public List<Order> getAllOrders() throws OrderException {

        List<Order> orders = orderRepository.findAll();

        if(orders.isEmpty()) throw new OrderException("Order List is empty!");

        return orders;
    }
    }

