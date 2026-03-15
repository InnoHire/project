package com.project.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.taskmanagement.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long>{

    User findByEmail(String email);

    // Get all managers
    List<User> findByRole(String role);

    // Search managers by experience
    List<User> findByRoleAndExperienceGreaterThanEqual(String role, int experience);
}