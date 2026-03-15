package com.innohireproject.innohireproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innohireproject.innohireproject.model.Task;
import com.innohireproject.innohireproject.repository.TaskRepository;

@Service
public class UserService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getUserTasks(Long userId){

        return taskRepository.findByUserId(userId);
    }

    public Task completeTask(Long taskId){

        Task task = taskRepository.findById(taskId).orElseThrow();

        task.setStatus("COMPLETED");

        return taskRepository.save(task);
    }

}