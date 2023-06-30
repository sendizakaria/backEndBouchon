package com.example.backendbouchon.service.repository.implementation;

import com.example.backendbouchon.dao.StudentRepository;
import com.example.backendbouchon.domaine.dto.StudentTO;
import com.example.backendbouchon.domaine.mapper.StudentMapper;
import com.example.backendbouchon.service.repository.signature.IStudentListService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements IStudentListService {

    private StudentRepository studentRepository;
    private StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository StudentRepository, StudentMapper studentMapper) {
        this.studentRepository = StudentRepository;
        this.studentMapper = studentMapper;
    }


    @Override
    public void saveStudent(StudentTO studentTO) {
        studentRepository.save(studentMapper.toStudentBO(studentTO));

    }

    @Override
    public List<StudentTO> getAllStudent() {
        return studentMapper.toListStudentTO(studentRepository.findAll());
    }

    @Override
    public StudentTO getStudentById(int id) {
        return  studentMapper.toStudentTO(studentRepository.findStudentById(id));
    }

    @Override
    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }

}
