package com.severusnguyen.schoolmangagement.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "grades")
public class Grades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Students studentId;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subjects subjectId;

    @Column(name = "grade")
    private float grade;

    @Column(name = "grade_type")
    private String gradeType;

    @Column(name = "grade_date")
    private Date gradeDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Students getStudentId() {
        return studentId;
    }

    public void setStudentId(Students studentId) {
        this.studentId = studentId;
    }

    public Subjects getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Subjects subjectId) {
        this.subjectId = subjectId;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public String getGradeType() {
        return gradeType;
    }

    public void setGradeType(String gradeType) {
        this.gradeType = gradeType;
    }

    public Date getGradeDate() {
        return gradeDate;
    }

    public void setGradeDate(Date gradeDate) {
        this.gradeDate = gradeDate;
    }
}
