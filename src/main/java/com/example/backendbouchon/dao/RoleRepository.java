package com.example.backendbouchon.dao;

import com.example.backendbouchon.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    List<Role> findByRole(String role);
    List<Role> findAll();
}
