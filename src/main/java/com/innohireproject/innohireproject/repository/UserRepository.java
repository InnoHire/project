package com.innohireproject.innohireproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innohireproject.innohireproject.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

    User findByEmail(String email);

    List<User> findByRole(String role);

    List<User> findBySkillsContaining(String skills);

    List<User> findByRoleAndExperienceGreaterThanEqual(String role,int experience);

}