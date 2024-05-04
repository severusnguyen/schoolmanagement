package com.severusnguyen.schoolmangagement.controller;

import com.severusnguyen.schoolmangagement.payload.ResponseData;
import com.severusnguyen.schoolmangagement.payload.request.GradeRequest;
import com.severusnguyen.schoolmangagement.payload.request.SubjectRequest;
import com.severusnguyen.schoolmangagement.service.imp.GradeServiceImp;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    GradeServiceImp gradeServiceImp;

//    @GetMapping("/privateKey")
//    public void privateKey(){
//        SecretKey key = Jwts.SIG.HS256.key().build(); //or HS384.key() or HS512.key()
//        String secretString = Encoders.BASE64.encode(key.getEncoded());
//        System.out.println(secretString);
//
//    }

    @GetMapping("")
    public ResponseEntity<?> getAllSubject(){

        ResponseData responseData = new ResponseData();
        responseData.setData(gradeServiceImp.getAllGrade());

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> insertSubject(@RequestBody GradeRequest gradeRequest){

        ResponseData responseData = new ResponseData();
        responseData.setData(gradeServiceImp.insertGrade(gradeRequest));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSubject(@PathVariable int id, @RequestBody GradeRequest gradeRequest){

        ResponseData responseData = new ResponseData();
        responseData.setData(gradeServiceImp.updateGrade(id, gradeRequest));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable int id){

        ResponseData responseData = new ResponseData();
        responseData.setData(gradeServiceImp.deleteGrade(id));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/searchByType")
    public ResponseEntity<?> searchByGradeType(@RequestParam String type){

        ResponseData responseData = new ResponseData();
        responseData.setData(gradeServiceImp.findByGradeType(type));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/searchByGrade")
    public ResponseEntity<?> searchByGradeGreaterThan(@RequestParam float grade){

        ResponseData responseData = new ResponseData();
        responseData.setData(gradeServiceImp.findByGradeGreaterThan(grade));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
