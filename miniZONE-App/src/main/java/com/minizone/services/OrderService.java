package com.minizone.services;

import java.util.List;
import com.minizone.entities.Order;

public interface OrderService {

    public String addOrder(Order order,Long addressId, Long userID) throws OrderException;

    public String deleteOrderById(Long orderID) throws OrderException;

    public Order getOrderById(Long orderID) throws OrderException;

    public List<Order> getAllOrders() throws OrderException;

}
