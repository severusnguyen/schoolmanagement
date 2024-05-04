package com.severusnguyen.schoolmangagement.controller;

import com.severusnguyen.schoolmangagement.payload.ResponseData;
import com.severusnguyen.schoolmangagement.payload.request.ClassRequest;
import com.severusnguyen.schoolmangagement.service.imp.ClassServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    ClassServiceImp classServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getAllClass(){

        ResponseData responseData = new ResponseData();
        responseData.setData(classServiceImp.getAllClass());

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> insertClass(@RequestBody ClassRequest classRequest){

        ResponseData responseData = new ResponseData();
        responseData.setData(classServiceImp.insertClass(classRequest));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClass(@PathVariable int id, @RequestBody ClassRequest classRequest){

        ResponseData responseData = new ResponseData();
        responseData.setData(classServiceImp.updateClass(id, classRequest));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClass(@PathVariable int id){

        ResponseData responseData = new ResponseData();
        responseData.setData(classServiceImp.deleteClass(id));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
