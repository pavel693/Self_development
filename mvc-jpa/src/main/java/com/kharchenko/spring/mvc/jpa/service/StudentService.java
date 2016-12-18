package com.kharchenko.spring.mvc.jpa.service;

import com.kharchenko.spring.mvc.jpa.model.Student;
import com.kharchenko.spring.mvc.jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.getStudents();
    }

    public Map<String, String> getStudentsMap() {
        List<Student> students = studentRepository.getStudents();

        Map<String, String> studentsMap = new HashMap<>();
        for (Student student : students) {
            String id = String.valueOf(student.getId());
            String name = student.getFirstname() + " " + student.getLastname();
            studentsMap.put(id, name);
        }

        return studentsMap;
    }

    public Student getStudentByName(String firstname, String lastname) {
        return studentRepository.getStudentByName(firstname, lastname);
    }
}
