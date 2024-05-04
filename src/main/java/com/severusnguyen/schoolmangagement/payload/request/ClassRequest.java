package com.severusnguyen.schoolmangagement.payload.request;

import com.severusnguyen.schoolmangagement.entity.Teachers;
import org.springframework.web.multipart.MultipartFile;

public class ClassRequest {
    private MultipartFile file;
    private int id;
    private String className;
    private int amountStudent;
    private String classHead;
    private String homeroomTeacher;
    private int teacherId;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

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

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
