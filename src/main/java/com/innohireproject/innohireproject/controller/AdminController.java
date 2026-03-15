package com.innohireproject.innohireproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.innohireproject.innohireproject.model.Task;
import com.innohireproject.innohireproject.model.User;
import com.innohireproject.innohireproject.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/search-manager/{exp}")
    public List<User> searchManager(@PathVariable int exp){

        return adminService.searchManager(exp);
    }

    @PostMapping("/create-task")
    public Task createTask(@RequestBody Task task){

        return adminService.createTask(task);
    }

    @PutMapping("/assign-manager/{taskId}/{managerId}")
    public Task assignManager(@PathVariable Long taskId, @PathVariable Long managerId){

        return adminService.assignManager(taskId, managerId);
    }

    @GetMapping("/tasks")
    public List<Task> trackTasks(){

        return adminService.getAllTasks();
    }

}