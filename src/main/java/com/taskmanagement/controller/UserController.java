package com.taskmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.taskmanagement.entity.User;
import com.taskmanagement.entity.Task;
import com.taskmanagement.service.UserService;
import com.taskmanagement.service.TaskService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {

        return userService.registerUser(user);

    }

    @GetMapping("/tasks/{userId}")
    public List<Task> getTasks(@PathVariable Long userId) {

        return taskService.getUserTasks(userId);

    }

    @PostMapping("/submit")
    public Task submitTask(@RequestBody Task task) {

        return taskService.submitTask(task);

    }
}