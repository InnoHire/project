package com.project.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.taskmanagement.model.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByManagerId(Long managerId);

    List<Task> findByUserId(Long userId);
}