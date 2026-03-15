package com.innohireproject.innohireproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innohireproject.innohireproject.model.Task;
import com.innohireproject.innohireproject.model.User;
import com.innohireproject.innohireproject.repository.TaskRepository;
import com.innohireproject.innohireproject.repository.UserRepository;

@Service
public class ManagerService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Task> getManagerTasks(Long managerId){

        return taskRepository.findByManagerId(managerId);
    }

    public List<User> searchUserBySkill(String skill){

        return userRepository.findBySkillsContaining(skill);
    }

    public Task assignUser(Long taskId, Long userId){

        Task task = taskRepository.findById(taskId).orElseThrow();

        task.setUserId(userId);
        task.setStatus("IN_PROGRESS");

        return taskRepository.save(task);
    }

    public Task submitToAdmin(Long taskId){

        Task task = taskRepository.findById(taskId).orElseThrow();

        task.setStatus("COMPLETED");

        return taskRepository.save(task);
    }

}