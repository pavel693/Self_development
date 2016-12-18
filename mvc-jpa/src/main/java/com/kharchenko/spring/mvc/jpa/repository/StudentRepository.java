package com.kharchenko.spring.mvc.jpa.repository;

import com.kharchenko.spring.mvc.jpa.model.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    EntityManager entityManager;

    public List<Student> getStudents() {
        Query query = entityManager.createQuery("from Student");
        return query.getResultList();
    }

    public Student getStudentByName(String firstname, String lastname) {
        Query query = entityManager.createQuery("from Student s where s.firstname = :fname " +
                "and s.lastname = :lname");
        query.setParameter("fname", firstname);
        query.setParameter("lname", lastname);

        List<Student> students = query.getResultList();
        if (students.isEmpty()) {
            return null;
        }

        return students.get(0);
    }
}
