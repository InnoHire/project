package com.logIn.logIn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.logIn.logIn.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}