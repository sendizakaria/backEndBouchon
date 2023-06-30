package com.example.backendbouchon.dao;

import com.example.backendbouchon.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String userName);
    Optional<User> findById(Long id);
    User findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsById(Long id);

}
