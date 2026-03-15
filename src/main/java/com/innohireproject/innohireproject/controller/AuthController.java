package com.innohireproject.innohireproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.innohireproject.innohireproject.dto.LoginRequest;
import com.innohireproject.innohireproject.dto.RegisterRequest;
import com.innohireproject.innohireproject.model.User;
import com.innohireproject.innohireproject.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request){

        return authService.register(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){

        return authService.login(request);
    }

}