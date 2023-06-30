package com.example.backendbouchon.domaine.mapper;

import com.example.backendbouchon.domaine.dto.StudentTO;
import com.example.backendbouchon.model.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",implementationName = "StudentMapperImpl")
public interface StudentMapper {

        StudentTO toStudentTO(Student student);

        Student toStudentBO(StudentTO roleTO);

        List<StudentTO> toListStudentTO(List<Student> listeStudent);



}
