package com.project.taskmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.project.taskmanagement.model.User;
import com.project.taskmanagement.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Save user or manager
    public User saveUser(User user){
        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    // Get all managers
    public List<User> getManagers(){
        return userRepository.findByRole("MANAGER");
    }

    // Search managers by experience
    public List<User> searchManagersByExperience(int experience){
        return userRepository.findByRoleAndExperienceGreaterThanEqual("MANAGER", experience);
    }
}