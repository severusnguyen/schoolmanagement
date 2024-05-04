package com.severusnguyen.schoolmangagement.service.imp;

import com.severusnguyen.schoolmangagement.dto.StudentDTO;
import com.severusnguyen.schoolmangagement.payload.request.StudentRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentServiceImp{
    List<StudentDTO> getAllStudent();
    boolean insertStudent( MultipartFile file,
                             String studentCode,
                             String password,
                             String studentName,
                             String email,
                             String phone,
                             String address,
                             boolean status,
                             String admissionDate,
                             String graduationDate,
                             int departmentId,
                             int classId);
    boolean updateStudent(int id,
                          MultipartFile file,
                          String studentCode,
                          String password,
                          String studentName,
                          String email,
                          String phone,
                          String address,
                          boolean status,
                          String admissionDate,
                          String graduationDate,
                          int departmentId,
                          int classId);
    boolean deleteStudent(int id);

    List<StudentDTO> searchStudentByEmail(String email);
    List<StudentDTO> searchStudentByStudentCode(String code);
    List<StudentDTO> searchStudentByPhone(String phone);
}
