package com.severusnguyen.schoolmangagement.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "student_code")
    private String studentCode;

    @Column(name = "password")
    private String password;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "image")
    private String image;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "status")
    private boolean status;

    @Column(name = "admission_date")
    private Date admissionDate;

    @Column(name = "graduation_date")
    private Date graduationDate;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments departmentId;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Classes classId;

//    @OneToMany(mappedBy = "studentId")
//    private Set<Grades> listGrades;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public Departments getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Departments departmentId) {
        this.departmentId = departmentId;
    }

    public Classes getClassId() {
        return classId;
    }

    public void setClassId(Classes classId) {
        this.classId = classId;
    }

//    public Set<Grades> getListGrades() {
//        return listGrades;
//    }
//
//    public void setListGrades(Set<Grades> listGrades) {
//        this.listGrades = listGrades;
//    }
}
