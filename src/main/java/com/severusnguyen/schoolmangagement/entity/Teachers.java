package com.severusnguyen.schoolmangagement.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "teachers")
public class Teachers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "teacher_code")
    private String teacherCode;

    @Column(name = "password")
    private String password;

    @Column(name = "teacher_name")
    private String teacherName;

    @Column(name = "image")
    private String image;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "start_date")
    private Date start_date;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments departmentId;

    @OneToOne(mappedBy = "teacher")
    private Classes classes;

    @OneToMany(mappedBy = "teachersId")
    private Set<Subjects> listSubjects;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Departments getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Departments departmentId) {
        this.departmentId = departmentId;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Set<Subjects> getListSubjects() {
        return listSubjects;
    }

    public void setListSubjects(Set<Subjects> listSubjects) {
        this.listSubjects = listSubjects;
    }
}
