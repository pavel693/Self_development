package com.kharchenko.spring.mvc.jpa.model;

import javax.persistence.*;

@Entity
@Table(name = "exams")
@NamedQueries({
        @NamedQuery(name = Exam.EXAMS_LIST, query = "from Exam"),
        @NamedQuery(name = Exam.EXAMS_REPORT, query =
                "select new com.kharchenko.spring.mvc.jpa.report.ExamsReport(sb.name," +
                        "sb.teacherName, e.grade) " +
                        "from Exam e, Subject sb, Student st where e.student.id = st.id and " +
                        "e.subject.id = sb.id and st.firstname = :fname and st.lastname = :lname")
})
public class Exam {

    public static final String EXAMS_LIST = "exams_list";
    public static final String EXAMS_REPORT = "exams_report";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Subject subject;

    private int grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
