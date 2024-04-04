package com.graphql.graphqlEx.service;

import com.graphql.graphqlEx.dao.UserRepo;
import com.graphql.graphqlEx.entity.User;

import java.util.List;

public interface UserService {
    public User createUser(User user);
    User updateUser(User user,Integer userId);

    User getUserById(Integer userId);

    List<User> getAllUsers();

    boolean deleteUser(Integer userId);

}
