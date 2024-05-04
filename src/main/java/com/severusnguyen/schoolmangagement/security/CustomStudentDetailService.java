package com.severusnguyen.schoolmangagement.security;

import com.severusnguyen.schoolmangagement.entity.Students;
import com.severusnguyen.schoolmangagement.reposirory.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//Làm này sau CustomFilterSecurity khi Encode xong
@Service
public class CustomStudentDetailService implements UserDetailsService {

    @Autowired
    StudentRepository studentsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //System.out.println("Kiểm tra: " + username);  Kiểm tra có nhận tham số hay không
        Students students = studentsRepository.findByStudentCode(username);

        if (students == null){
            throw new  UsernameNotFoundException("Student not exist.");
        }
        // System.out.println("Kiểm tra lấy: " + students.getUserName()); kiểm tra xem có query được data hay không 
        return new User(username, students.getPassword(), new ArrayList<>());

    }
}
