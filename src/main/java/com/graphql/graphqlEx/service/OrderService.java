package com.graphql.graphqlEx.service;

import com.graphql.graphqlEx.entity.Order;

import java.util.List;

public interface OrderService {

    public Order createOrder(Order order);
    public List<Order> getAllOrders();
    public Order getOrder(Integer orderID);
    public boolean deleteOrder(Integer orderId);
}
