package com.example.backendbouchon.dao;

import com.example.backendbouchon.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findStudentById(int id);

}
