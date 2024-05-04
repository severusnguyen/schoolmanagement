package com.severusnguyen.schoolmangagement.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.Set;

@Entity(name = "departments")
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "department_code")
    private String departmentCode;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "department_description")
    private String departmentDesc;

    @Column(name = "department_head")
    private String departmentHead;

//    @OneToMany(mappedBy = "departmentId")
//    private Set<Teachers> listTeachers;
//
//    @OneToMany(mappedBy = "departmentId")
//    private Set<Students> listStudents;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDesc() {
        return departmentDesc;
    }

    public void setDepartmentDesc(String departmentDesc) {
        this.departmentDesc = departmentDesc;
    }

    public String getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(String departmentHead) {
        this.departmentHead = departmentHead;
    }

//    public Set<Teachers> getListTeachers() {
//        return listTeachers;
//    }
//
//    public void setListTeachers(Set<Teachers> listTeachers) {
//        this.listTeachers = listTeachers;
//    }
//
//    public Set<Students> getListStudents() {
//        return listStudents;
//    }

//    public void setListStudents(Set<Students> listStudents) {
//        this.listStudents = listStudents;
//    }
}
