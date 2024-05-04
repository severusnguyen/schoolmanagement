package com.severusnguyen.schoolmangagement.controller;

import com.severusnguyen.schoolmangagement.payload.ResponseData;
import com.severusnguyen.schoolmangagement.payload.request.DepartmentRequest;
import com.severusnguyen.schoolmangagement.service.imp.DepartmentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentServiceImp departmentServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getAllDepartment(){

        ResponseData responseData = new ResponseData();
        responseData.setData(departmentServiceImp.getAllDepartment());

        return new ResponseEntity<>(responseData, HttpStatus.OK );
    }

    @PostMapping("")
    public ResponseEntity<?> insertTeacher(@RequestBody DepartmentRequest departmentRequest){

        ResponseData responseData = new ResponseData();
        responseData.setData(departmentServiceImp.insertTeacher(departmentRequest));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable int id,
                                              @RequestBody DepartmentRequest departmentRequest){

        ResponseData responseData = new ResponseData();
        responseData.setData(departmentServiceImp.updateDepartment(id, departmentRequest));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable int id){

        ResponseData responseData = new ResponseData();
        responseData.setData(departmentServiceImp.deleteDepartment(id));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/searchById")
    public ResponseEntity<?> searchDepartmentById(@RequestParam int id){

        ResponseData responseData = new ResponseData();
        responseData.setData(departmentServiceImp.deleteDepartment(id));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
