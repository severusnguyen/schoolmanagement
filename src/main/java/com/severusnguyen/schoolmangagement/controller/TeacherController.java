package com.severusnguyen.schoolmangagement.controller;

import com.severusnguyen.schoolmangagement.entity.Departments;
import com.severusnguyen.schoolmangagement.payload.ResponseData;
import com.severusnguyen.schoolmangagement.payload.request.TeacherRequest;
import com.severusnguyen.schoolmangagement.service.imp.TeacherServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherServiceImp teacherServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getAllTeacher(){

        ResponseData responseData = new ResponseData();
        responseData.setData(teacherServiceImp.getAllTeacher());

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> insertTeacher(@RequestBody MultipartFile file,
                                           @RequestParam String teacherCode,
                                           @RequestParam String password,
                                           @RequestParam String teacherName,
                                           @RequestParam String email,
                                           @RequestParam String phone,
                                           @RequestParam String address,
                                           @RequestParam String startDate,
                                           @RequestParam int departmentId){

        ResponseData responseData = new ResponseData();
        responseData.setData(teacherServiceImp.insertTeacher(file, teacherCode, password, teacherName, email, phone, address, startDate, departmentId));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable int id,
                                           @RequestParam MultipartFile file,
                                           @RequestParam String teacherCode,
                                           @RequestParam String password,
                                           @RequestParam String teacherName,
                                           @RequestParam String email,
                                           @RequestParam String phone,
                                           @RequestParam String address,
                                           @RequestParam String startDate,
                                           @RequestParam int departmentId){

        ResponseData responseData = new ResponseData();
        responseData.setData(teacherServiceImp.updateTeacher(id, file, teacherCode, password, teacherName, email, phone, address, startDate, departmentId));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteTeacher(int id){
        ResponseData responseData = new ResponseData();
        responseData.setData(teacherServiceImp.deleteTeacher(id));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/searchByEmail")
    public ResponseEntity<?> searchStudentByEmail(@RequestParam String email){

        ResponseData responseData = new ResponseData();
        responseData.setData(teacherServiceImp.searchTeacherByEmail(email));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/searchByCode")
    public ResponseEntity<?> searchTeacherByCode(@RequestParam String code){

        ResponseData responseData = new ResponseData();
        responseData.setData(teacherServiceImp.searchTeacherByTeacherCode(code));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
