package com.innohireproject.innohireproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.innohireproject.innohireproject.model.Task;
import com.innohireproject.innohireproject.model.User;
import com.innohireproject.innohireproject.service.ManagerService;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("/tasks/{managerId}")
    public List<Task> getTasks(@PathVariable Long managerId){

        return managerService.getManagerTasks(managerId);
    }

    @GetMapping("/search-user/{skill}")
    public List<User> searchUser(@PathVariable String skill){

        return managerService.searchUserBySkill(skill);
    }

    @PutMapping("/assign-user/{taskId}/{userId}")
    public Task assignUser(@PathVariable Long taskId, @PathVariable Long userId){

        return managerService.assignUser(taskId, userId);
    }

    @PutMapping("/submit-task/{taskId}")
    public Task submitTask(@PathVariable Long taskId){

        return managerService.submitToAdmin(taskId);
    }

}