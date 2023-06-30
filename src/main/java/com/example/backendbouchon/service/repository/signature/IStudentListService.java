package com.example.backendbouchon.service.repository.signature;

import com.example.backendbouchon.domaine.dto.StudentTO;

import java.util.List;

public interface IStudentListService {

    void saveStudent(StudentTO studentTO);
    List<StudentTO> getAllStudent();
    StudentTO getStudentById(int id);

    void deleteAllStudents();
}
