package com.kharchenko.spring.mvc.jpa.repository;

import com.kharchenko.spring.mvc.jpa.model.Subject;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class SubjectRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Subject> getSubjects() {
        Query query = entityManager.createQuery("from Subject");
        return query.getResultList();
    }
}
