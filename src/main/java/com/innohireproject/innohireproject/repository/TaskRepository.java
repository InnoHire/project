package com.innohireproject.innohireproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innohireproject.innohireproject.model.Task;

public interface TaskRepository extends JpaRepository<Task,Long>{

    List<Task> findByManagerId(Long managerId);

    List<Task> findByUserId(Long userId);

}