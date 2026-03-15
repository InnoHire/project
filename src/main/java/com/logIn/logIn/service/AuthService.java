package com.logIn.logIn.service;

import com.logIn.logIn.dto.LoginRequest;
import com.logIn.logIn.dto.RegisterRequest;
import com.logIn.logIn.model.User;
import com.logIn.logIn.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public User register(RegisterRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        return userRepository.save(user);
    }

    public String login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        return "Login Successful as " + user.getRole();
    }
}

