package com.kharchenko.spring.baseapp.service;

import com.kharchenko.spring.baseapp.model.Student;

import java.util.List;

public interface UniversityService {

    public List<Student> getAvailableStudents();
}

