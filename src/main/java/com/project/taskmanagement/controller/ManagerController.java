package com.project.taskmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.taskmanagement.model.Task;
import com.project.taskmanagement.model.User;
import com.project.taskmanagement.service.ManagerService;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    // view manager tasks
    @GetMapping("/tasks/{managerId}")
    public List<Task> getTasks(@PathVariable Long managerId){
        return managerService.getManagerTasks(managerId);
    }

    // search developers
    @GetMapping("/search-users")
    public List<User> searchUsers(@RequestParam String skill){
        return managerService.searchUsersBySkill(skill);
    }

    // assign task
    @PutMapping("/assign-task")
    public Task assignTask(@RequestParam Long taskId,
                           @RequestParam Long userId){
        return managerService.assignTaskToUser(taskId,userId);
    }

    // submit task to admin
    @PutMapping("/submit-task/{taskId}")
    public Task submitTask(@PathVariable Long taskId){
        return managerService.submitTaskToAdmin(taskId);
    }
}