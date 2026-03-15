package com.innohireproject.innohireproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innohireproject.innohireproject.model.Task;
import com.innohireproject.innohireproject.model.User;
import com.innohireproject.innohireproject.repository.TaskRepository;
import com.innohireproject.innohireproject.repository.UserRepository;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    public List<User> searchManager(int exp){
        return userRepository.findByRoleAndExperienceGreaterThanEqual("MANAGER", exp);
    }

    public Task createTask(Task task){

        task.setStatus("PENDING");

        return taskRepository.save(task);
    }

    public Task assignManager(Long taskId, Long managerId){

        Task task = taskRepository.findById(taskId).orElseThrow();

        task.setManagerId(managerId);
        task.setStatus("ASSIGNED");

        return taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

}