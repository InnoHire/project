package com.project.taskmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.taskmanagement.model.Task;
import com.project.taskmanagement.repository.TaskRepository;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    // 1️⃣ Create Task (Admin creates task)
    @PostMapping
    public Task createTask(@RequestBody Task task){
        task.setStatus("CREATED");
        return taskRepository.save(task);
    }

    // 2️⃣ Get All Tasks
    @GetMapping
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    // 3️⃣ Get Task by ID
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id){
        return taskRepository.findById(id).orElse(null);
    }

    // 4️⃣ Developer completes task
    @PutMapping("/complete/{taskId}")
    public Task completeTask(@PathVariable Long taskId){

        Task task = taskRepository.findById(taskId).orElse(null);

        if(task != null){
            task.setStatus("COMPLETED");
            return taskRepository.save(task);
        }

        return null;
    }

    // 5️⃣ Delete task (Admin)
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id){

        taskRepository.deleteById(id);

        return "Task deleted successfully";
    }
}