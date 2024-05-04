package com.severusnguyen.schoolmangagement.payload.request;

import com.severusnguyen.schoolmangagement.entity.Students;
import com.severusnguyen.schoolmangagement.entity.Subjects;

import java.util.Date;

public class GradeRequest {
    private int studentId;
    private int subjectId;
    private float grade;
    private String gradeType;
    private String gradeDate;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
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

    public String getGradeDate() {
        return gradeDate;
    }

    public void setGradeDate(String gradeDate) {
        this.gradeDate = gradeDate;
    }
}
