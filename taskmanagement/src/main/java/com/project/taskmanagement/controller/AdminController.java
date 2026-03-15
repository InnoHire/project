package com.project.taskmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.taskmanagement.model.Task;
import com.project.taskmanagement.model.User;
import com.project.taskmanagement.repository.TaskRepository;
import com.project.taskmanagement.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    // 1️⃣ Create Task
    @PostMapping("/createTask")
    public Task createTask(@RequestBody Task task){
        task.setStatus("CREATED");
        return taskRepository.save(task);
    }

    // 2️⃣ View All Tasks
    @GetMapping("/tasks")
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    // 3️⃣ View All Managers
    @GetMapping("/managers")
    public List<User> getManagers(){
        return userService.getManagers();
    }

    // 4️⃣ Search Managers by Experience
    @GetMapping("/managers/experience/{exp}")
    public List<User> searchManagersByExperience(@PathVariable int exp){
        return userService.searchManagersByExperience(exp);
    }

    // 5️⃣ Assign Manager to Task
    @PostMapping("/assignManager/{taskId}/{managerId}")
    public Task assignManager(@PathVariable Long taskId,
                              @PathVariable Long managerId){

        Task task = taskRepository.findById(taskId).get();
        task.setManagerId(managerId);
        task.setStatus("ASSIGNED_TO_MANAGER");

        return taskRepository.save(task);
    }
}