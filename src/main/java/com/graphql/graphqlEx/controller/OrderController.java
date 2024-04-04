package com.graphql.graphqlEx.controller;

import com.graphql.graphqlEx.entity.Order;
import com.graphql.graphqlEx.service.OrderService;
import com.graphql.graphqlEx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderController {

    //This is order controller
    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;

    @MutationMapping
    public Order createOrder(@Argument String orderDetail,@Argument String  address,@Argument int price, @Argument int userId)
    {
        Order o = new Order();
        o.setOrderDetail(orderDetail);
        o.setAddress(address);
        o.setPrice(price);
        o.setUser(userService.getUserById(userId));

        return  orderService.createOrder(o);
    }
    @QueryMapping
    public List<Order> getOrders(){
        return orderService.getAllOrders();
    }

    @QueryMapping
    public Order getOrder(@Argument int orderId){
        return orderService.getOrder(orderId);
    }

    @MutationMapping
    public boolean deleteOrder(@Argument  int orderId){
        return orderService.deleteOrder(orderId);
    }

}
