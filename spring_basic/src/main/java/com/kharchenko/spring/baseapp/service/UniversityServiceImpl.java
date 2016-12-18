package com.kharchenko.spring.baseapp.service;

import com.kharchenko.spring.baseapp.model.Student;
import com.kharchenko.spring.baseapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("universityService")
public class UniversityServiceImpl implements UniversityService {
    @Autowired
    StudentRepository studentRepository;

    public UniversityServiceImpl() {
    }

    @Autowired
    public UniversityServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAvailableStudents() {
        return studentRepository.getStudents();
    }

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}

