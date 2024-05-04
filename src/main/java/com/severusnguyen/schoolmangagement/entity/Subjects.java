package com.severusnguyen.schoolmangagement.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "subjects")
public class Subjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "subjects_name")
    private String subjectsName;

    @Column(name = "subjects_code")
    private String subjects_code;

    @Column(name = "credits")
    private int credits;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Classes teacherId;

    @ManyToOne
    @JoinColumn(name = "teacher_id", insertable=false, updatable=false)
    private Teachers teachersId;

    @OneToMany(mappedBy = "subjectId")
    private Set<Grades> listGrades;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectsName() {
        return subjectsName;
    }

    public void setSubjectsName(String subjectsName) {
        this.subjectsName = subjectsName;
    }

    public String getSubjects_code() {
        return subjects_code;
    }

    public void setSubjects_code(String subjects_code) {
        this.subjects_code = subjects_code;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Classes getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Classes teacherId) {
        this.teacherId = teacherId;
    }

    public Teachers getTeachersId() {
        return teachersId;
    }

    public void setTeachersId(Teachers teachersId) {
        this.teachersId = teachersId;
    }

    public Set<Grades> getListGrades() {
        return listGrades;
    }

    public void setListGrades(Set<Grades> listGrades) {
        this.listGrades = listGrades;
    }
}
