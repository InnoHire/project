package com.project.taskmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.taskmanagement.model.User;
import com.project.taskmanagement.model.Role;
import com.project.taskmanagement.model.Task;
import com.project.taskmanagement.repository.UserRepository;
import com.project.taskmanagement.repository.TaskRepository;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    // Admin searches managers by experience
    @GetMapping("/search-manager")
    public List<User> searchManager(@RequestParam int experience){
        return userRepository.findByRoleAndExperienceGreaterThanEqual(Role.MANAGER, experience);
    }

    // Admin assigns task to manager
    @PutMapping("/assign-task")
    public Task assignTaskToManager(@RequestParam Long taskId,
                                    @RequestParam Long managerId){

        Task task = taskRepository.findById(taskId).orElse(null);

        if(task != null){
            task.setManagerId(managerId);
            return taskRepository.save(task);
        }

        return null;
    }

}