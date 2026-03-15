package com.taskmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.taskmanagement.entity.Task;
import com.taskmanagement.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getUserTasks(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    public Task submitTask(Task task) {
        task.setStatus("SUBMITTED_TO_MANAGER");
        return taskRepository.save(task);
    }
}