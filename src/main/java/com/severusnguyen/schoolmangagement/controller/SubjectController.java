package com.severusnguyen.schoolmangagement.controller;

import com.severusnguyen.schoolmangagement.payload.ResponseData;
import com.severusnguyen.schoolmangagement.payload.request.SubjectRequest;
import com.severusnguyen.schoolmangagement.service.imp.SubjectServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectServiceImp subjectServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getAllSubject(){

        ResponseData responseData = new ResponseData();

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> insertSubject(@RequestBody SubjectRequest subjectRequest){

        ResponseData responseData = new ResponseData();
        responseData.setData(subjectServiceImp.insertSubject(subjectRequest));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSubject(@PathVariable int id, @RequestBody SubjectRequest subjectRequest){

        ResponseData responseData = new ResponseData();
        responseData.setData(subjectServiceImp.updateSubject(id, subjectRequest));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable int id){

        ResponseData responseData = new ResponseData();
        responseData.setData(subjectServiceImp.deleteSubject(id));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
