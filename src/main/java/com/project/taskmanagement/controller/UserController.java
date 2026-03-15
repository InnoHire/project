package com.project.taskmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.taskmanagement.model.User;
import com.project.taskmanagement.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Create User
    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    // Get All Users
    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}