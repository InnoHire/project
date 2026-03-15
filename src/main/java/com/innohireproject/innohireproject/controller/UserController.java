package com.innohireproject.innohireproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.innohireproject.innohireproject.model.Task;
import com.innohireproject.innohireproject.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/tasks/{userId}")
    public List<Task> getTasks(@PathVariable Long userId){

        return userService.getUserTasks(userId);
    }

    @PutMapping("/complete-task/{taskId}")
    public Task completeTask(@PathVariable Long taskId){

        return userService.completeTask(taskId);
    }

}