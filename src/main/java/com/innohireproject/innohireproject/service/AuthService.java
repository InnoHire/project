package com.innohireproject.innohireproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innohireproject.innohireproject.dto.LoginRequest;
import com.innohireproject.innohireproject.dto.RegisterRequest;
import com.innohireproject.innohireproject.model.User;
import com.innohireproject.innohireproject.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public User register(RegisterRequest request){

        User user = new User();

        user.setName(request.name);
        user.setEmail(request.email);
        user.setPassword(request.password);
        user.setRole(request.role);
        user.setSkills(request.skills);
        user.setExperience(request.experience);

        return userRepository.save(user);
    }

    public String login(LoginRequest request){

        User user = userRepository.findByEmail(request.email);

        if(user == null)
            return "User not found";

        if(!user.getPassword().equals(request.password))
            return "Invalid password";

        return "Login successful : " + user.getRole();
    }
}