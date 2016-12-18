package com.kharchenko.spring.baseapp.repository;


import com.kharchenko.spring.baseapp.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("studentRepository")
public class StudentRepositoryImpl implements StudentRepository {

    public List<Student> getStudents() {

        List<Student> students = new ArrayList<>();

        Student student = new Student("River", "Song", 25);
        Student student2 = new Student("Smith", "John", 35);

        students.add(student);
        students.add(student2);

        return students;
    }
}


