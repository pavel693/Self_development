package com.kharchenko.spring.baseapp;

import com.kharchenko.spring.baseapp.model.Student;
import com.kharchenko.spring.baseapp.service.UniversityService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainApplication {

    public static void main(String[] args) {

        //UniversityService universityService = new UniversityServiceImpl();
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UniversityService universityService = applicationContext.getBean("universityService", UniversityService.class);

        List<Student> students = universityService.getAvailableStudents();

        for (Student student : students) {
            System.out.println(student.getLastname() +
                    " " + student.getFirstname() +
                    " " + student.getAge() + " years old");
        }
    }
}

