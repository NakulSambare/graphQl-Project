package com.graphql.graphqlEx.controller;

import com.graphql.graphqlEx.entity.User;
import com.graphql.graphqlEx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService ;

    @MutationMapping
    public User createUser(@Argument String name,@Argument String phone,@Argument String email,@Argument String password){
        User u =new User();
        u.setName(name);
        u.setEmail(email);
        u.setPhone(phone);
        u.setPassword(password);
        return userService.createUser(u);
    }

    @QueryMapping(name = "getUsers")
    public List<User> getAllUsers(){
            return userService.getAllUsers();
    }

    @QueryMapping
    public User getUser(@Argument int userId){
        return userService.getUserById(userId);
    }

    @MutationMapping
    public boolean deleteUser(@Argument int userId){
        return userService.deleteUser(userId);
    }


}
