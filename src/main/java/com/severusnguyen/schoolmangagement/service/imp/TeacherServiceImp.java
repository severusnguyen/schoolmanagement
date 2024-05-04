package com.severusnguyen.schoolmangagement.service.imp;

import com.severusnguyen.schoolmangagement.dto.StudentDTO;
import com.severusnguyen.schoolmangagement.dto.TeacherDTO;
import com.severusnguyen.schoolmangagement.payload.request.TeacherRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TeacherServiceImp {
    List<TeacherDTO> getAllTeacher();
    boolean insertTeacher(MultipartFile file,
                          String teacherCode,
                          String password,
                          String teacherName,
                          String email,
                          String phone,
                          String address,
                          String startDate,
                          int departmentId);

    boolean updateTeacher(int id,
                          MultipartFile file,
                          String teacherCode,
                          String password,
                          String teacherName,
                          String email,
                          String phone,
                          String address,
                          String startDate,
                          int departmentId);

    boolean deleteTeacher(int id);

    List<TeacherDTO> searchTeacherByEmail(String email);
    TeacherDTO searchTeacherByTeacherCode(String code);
}
