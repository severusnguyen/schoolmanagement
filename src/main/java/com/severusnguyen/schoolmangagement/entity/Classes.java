package com.severusnguyen.schoolmangagement.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "classes")
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "class_name")
    private String className;

    @Column(name = "amount_student")
    private int amountStudent;

    @Column(name = "class_head")
    private String classHead;

    @Column(name = "homeroom_teacher")
    private String homeroomTeacher;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teachers teacher;

    @OneToMany(mappedBy = "classId")
    private Set<Students> listStudents;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getAmountStudent() {
        return amountStudent;
    }

    public void setAmountStudent(int amountStudent) {
        this.amountStudent = amountStudent;
    }

    public String getClassHead() {
        return classHead;
    }

    public void setClassHead(String classHead) {
        this.classHead = classHead;
    }

    public String getHomeroomTeacher() {
        return homeroomTeacher;
    }

    public void setHomeroomTeacher(String homeroomTeacher) {
        this.homeroomTeacher = homeroomTeacher;
    }

    public Teachers getTeacher() {
        return teacher;
    }

    public void setTeacher(Teachers teacher) {
        this.teacher = teacher;
    }

    public Set<Students> getListStudents() {
        return listStudents;
    }

    public void setListStudents(Set<Students> listStudents) {
        this.listStudents = listStudents;
    }
}
