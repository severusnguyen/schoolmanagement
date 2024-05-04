package com.severusnguyen.schoolmangagement.service.imp;

import com.severusnguyen.schoolmangagement.dto.StudentDTO;
import com.severusnguyen.schoolmangagement.payload.request.SignUpRequest;

import java.util.List;

public interface LoginServiceImp {
    //List<StudentDTO> getAllStudents();
    boolean ckeckLogin(String username, String password);
    boolean addStudent(SignUpRequest signUpRequest);
}
