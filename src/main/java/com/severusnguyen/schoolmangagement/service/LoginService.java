package com.severusnguyen.schoolmangagement.service;

import com.severusnguyen.schoolmangagement.entity.Students;
import com.severusnguyen.schoolmangagement.payload.request.SignUpRequest;
import com.severusnguyen.schoolmangagement.reposirory.StudentRepository;
import com.severusnguyen.schoolmangagement.service.imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService implements LoginServiceImp {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

//    public List<StudentsDTO> getAllStudents(){
//        List<Students> studentsList = studentsRepository.findAll();
//        List<StudentsDTO> studentsDTOS = new ArrayList<>();
//
//        for (Students students : studentsList) {
//            StudentsDTO studentsDTO = new StudentsDTO();
//            studentsDTO.setId(students.getId());
//            studentsDTO.setUsername(students.getUserName());
//            studentsDTO.setFullname(students.getFullname());
//            studentsDTO.setPassword(students.getPassword());
//
//            studentsDTOS.add(studentsDTO);
//            //System.out.println("List students: " + students.getFullname());
//        }
//        return studentsDTOS;
//    }

    @Override
    public boolean ckeckLogin(String username, String password) {

        Students students = studentRepository.findByStudentCode(username);

//        if (students == null){
//            return false;
//        }
//        return  true;

        return passwordEncoder.matches(password, students.getPassword());
    }

    @Override
    public boolean addStudent(SignUpRequest signUpRequest) {

        Students students = new Students();
        students.setStudentCode(signUpRequest.getUsername());
        students.setStudentName(signUpRequest.getFullname());
        students.setPassword(signUpRequest.getPassword());

        try {
            studentRepository.save(students);

            return true;
        } catch (Exception e){
            return false;
        }
    }
}
