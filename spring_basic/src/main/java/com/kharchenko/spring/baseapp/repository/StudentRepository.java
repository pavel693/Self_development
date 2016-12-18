package com.kharchenko.spring.baseapp.repository;

import com.kharchenko.spring.baseapp.model.Student;

import java.util.List;

public interface StudentRepository {

    public List<Student> getStudents();
}

