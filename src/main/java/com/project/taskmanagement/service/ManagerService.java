package com.project.taskmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.taskmanagement.model.Task;
import com.project.taskmanagement.model.User;
import com.project.taskmanagement.repository.TaskRepository;
import com.project.taskmanagement.repository.UserRepository;

@Service
public class ManagerService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    // View tasks assigned to manager
    public List<Task> getManagerTasks(Long managerId) {
        return taskRepository.findByManagerId(managerId);
    }

    // Search users by skill
    public List<User> searchUsersBySkill(String skill) {
        return userRepository.findBySkillsContaining(skill);
    }

    // Assign task to user
    public Task assignTaskToUser(Long taskId, Long userId) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setUserId(userId);
        task.setStatus("ASSIGNED_TO_USER");

        return taskRepository.save(task);
    }

    // Submit task to admin
    public Task submitTaskToAdmin(Long taskId) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setStatus("SUBMITTED_TO_ADMIN");

        return taskRepository.save(task);
    }
}