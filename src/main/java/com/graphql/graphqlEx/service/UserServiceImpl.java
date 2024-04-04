package com.graphql.graphqlEx.service;

import com.graphql.graphqlEx.dao.UserRepo;
import com.graphql.graphqlEx.entity.User;
import com.graphql.graphqlEx.helper.ExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userRepo;


    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User user, Integer userId) {
        return null;
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public boolean deleteUser(Integer userId) {
     User user =   userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        userRepo.delete(user);
        return true;
    }
}
