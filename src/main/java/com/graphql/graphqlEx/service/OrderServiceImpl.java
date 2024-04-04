package com.graphql.graphqlEx.service;

import com.graphql.graphqlEx.dao.OrderRepo;
import com.graphql.graphqlEx.entity.Order;
import com.graphql.graphqlEx.helper.ExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepo orderRepo;

    public Order  createOrder(Order order){
      return   orderRepo.save(order);
    }

    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }

    public Order getOrder(Integer orderID){
        return  orderRepo.findById(orderID).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
    }

    public boolean deleteOrder(Integer orderId){
        Order order =  orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        orderRepo.delete(order);
        return true;
    }

}
