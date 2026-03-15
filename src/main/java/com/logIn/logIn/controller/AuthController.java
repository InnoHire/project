package com.logIn.logIn.controller;


import com.logIn.logIn.dto.LoginRequest;
import com.logIn.logIn.dto.RegisterRequest;
import com.logIn.logIn.model.User;
import com.logIn.logIn.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {

        return authService.register(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        return authService.login(request);
    }

}

