package com.kharchenko.spring.mvc.jpa.repository;

import com.kharchenko.spring.mvc.jpa.model.Exam;
import com.kharchenko.spring.mvc.jpa.report.ExamsReport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ExamRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Exam> getExams() {
        Query query = entityManager.createNamedQuery(Exam.EXAMS_LIST);
        return query.getResultList();
    }

    public void addExam(Exam exam) {
        entityManager.persist(exam);
        entityManager.flush();
    }

    public List<ExamsReport> getExamsResults(String firstname, String lastname) {
        Query query = entityManager.createNamedQuery(Exam.EXAMS_REPORT);
        query.setParameter("fname", firstname);
        query.setParameter("lname", lastname);
        return query.getResultList();
    }
}
