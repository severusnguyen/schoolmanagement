package com.severusnguyen.schoolmangagement.controller;

import com.severusnguyen.schoolmangagement.payload.ResponseData;
import com.severusnguyen.schoolmangagement.payload.request.StudentRequest;
import com.severusnguyen.schoolmangagement.service.imp.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentServiceImp studentServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getAllStudent(){

        ResponseData responseData = new ResponseData();

        responseData.setData(studentServiceImp.getAllStudent());

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> insertStudent(@RequestParam MultipartFile file,
                                            @RequestParam String studentCode,
                                            @RequestParam String password,
                                            @RequestParam String studentName,
                                            @RequestParam String email,
                                            @RequestParam String phone,
                                            @RequestParam String address,
                                            @RequestParam boolean status,
                                            @RequestParam String admissionDate,
                                            @RequestParam String graduationDate,
                                            @RequestParam int departmentId,
                                            @RequestParam int classId){

        ResponseData responseData = new ResponseData();
        responseData.setData(studentServiceImp.insertStudent(file, studentCode, password, studentName,email, phone, address, status, admissionDate, graduationDate, departmentId, classId));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id,
                                           @RequestParam MultipartFile file,
                                           @RequestParam String studentCode,
                                           @RequestParam String password,
                                           @RequestParam String studentName,
                                           @RequestParam String email,
                                           @RequestParam String phone,
                                           @RequestParam String address,
                                           @RequestParam boolean status,
                                           @RequestParam String admissionDate,
                                           @RequestParam String graduationDate,
                                           @RequestParam int departmentId,
                                           @RequestParam int classId){

        ResponseData responseData = new ResponseData();
        responseData.setData(studentServiceImp.updateStudent(id, file, studentCode, password, studentName,email, phone, address, status, admissionDate, graduationDate, departmentId, classId));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id){

        ResponseData responseData = new ResponseData();
        responseData.setData(studentServiceImp.deleteStudent(id));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/searchByEmail")
    public ResponseEntity<?> searchStudentByEmail(@RequestParam String email){

        ResponseData responseData = new ResponseData();
        responseData.setData(studentServiceImp.searchStudentByEmail(email));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/searchByCode")
    public ResponseEntity<?> searchStudentByCode(@RequestParam String code){

        ResponseData responseData = new ResponseData();
        responseData.setData(studentServiceImp.searchStudentByStudentCode(code));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/searchByPhone")
    public ResponseEntity<?> searchStudentByPhone(@RequestParam String phone){

        ResponseData responseData = new ResponseData();
        responseData.setData(studentServiceImp.searchStudentByPhone(phone));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
