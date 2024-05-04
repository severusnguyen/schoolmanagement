package com.severusnguyen.schoolmangagement.dto;

import com.severusnguyen.schoolmangagement.entity.Students;
import com.severusnguyen.schoolmangagement.entity.Subjects;

import java.util.Date;

public class GradeDTO {
    private Students studentId;
    private Subjects subjectId;
    private float grade;
    private String gradeType;
    private Object gradeDate;

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

    public Object getGradeDate() {
        return gradeDate;
    }

    public void setGradeDate(Object gradeDate) {
        this.gradeDate = gradeDate;
    }
}
