package com.severusnguyen.schoolmangagement.controller;

import com.severusnguyen.schoolmangagement.payload.ResponseData;
import com.severusnguyen.schoolmangagement.payload.request.LoginRequet;
import com.severusnguyen.schoolmangagement.payload.request.SignUpRequest;
import com.severusnguyen.schoolmangagement.service.imp.LoginServiceImp;
import com.severusnguyen.schoolmangagement.util.JwtUtilHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginServiceImp loginServiceImp;

    @Autowired
    JwtUtilHelper jwtUtilHelper;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody LoginRequet loginRequet) {

        ResponseData responseData = new ResponseData();
//        if (loginServiceImp.ckeckLogin(loginRequet.getUsername(), loginRequet.getPassword())) {
//            responseData.setData(true);
//        } else {
//            responseData.setData("");
//        }

        if (loginServiceImp.ckeckLogin(loginRequet.getUsername(), loginRequet.getPassword())) {
            String token = jwtUtilHelper.generateToken(loginRequet.getUsername()); // Sinh ra token và Mã hóa username để sau này truy vấn
            responseData.setData(token);
        } else {
            responseData.setData("");
            responseData.setData(false);
        }

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest signUpRequest) {

        ResponseData responseData = new ResponseData();

        responseData.setData(loginServiceImp.addStudent(signUpRequest));

        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }
}
