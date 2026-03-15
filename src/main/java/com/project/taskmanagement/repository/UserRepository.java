package com.project.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.taskmanagement.model.User;
import com.project.taskmanagement.model.Role;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByRole(Role role);

    List<User> findByRoleAndExperienceGreaterThanEqual(Role role, int experience);

    List<User> findBySkillsContaining(String skill);
}