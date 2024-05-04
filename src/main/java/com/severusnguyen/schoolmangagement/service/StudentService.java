package com.severusnguyen.schoolmangagement.service;

import com.severusnguyen.schoolmangagement.dto.StudentDTO;
import com.severusnguyen.schoolmangagement.entity.Classes;
import com.severusnguyen.schoolmangagement.entity.Departments;
import com.severusnguyen.schoolmangagement.entity.Students;
import com.severusnguyen.schoolmangagement.payload.request.StudentRequest;
import com.severusnguyen.schoolmangagement.reposirory.StudentRepository;
import com.severusnguyen.schoolmangagement.service.imp.FileServiceImp;
import com.severusnguyen.schoolmangagement.service.imp.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements StudentServiceImp {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    FileServiceImp fileServiceImp;

    @Override
    public List<StudentDTO> getAllStudent() {

        PageRequest pageRequest = PageRequest.of(0, 6);
        Page<Students> studentList = studentRepository.findAll(pageRequest);
        List<StudentDTO> studentDTOList = new ArrayList<>();

        for (Students students : studentList) {
            StudentDTO studentDTO = new StudentDTO();

            studentDTO.setStudentCode(students.getStudentCode());
            studentDTO.setPassword(students.getPassword());
            studentDTO.setStudentName(students.getStudentName());
            studentDTO.setImage(students.getImage());
            studentDTO.setEmail(students.getEmail());
            studentDTO.setPhone(students.getPhone());
            studentDTO.setAddress(students.getAddress());
            studentDTO.setStatus(students.isStatus());
            studentDTO.setAdmissionDate(students.getAdmissionDate());
            studentDTO.setGraduationDate(students.getGraduationDate());
            studentDTO.setDepartmentId(students.getDepartmentId().getId());
            studentDTO.setClassId(students.getClassId().getId());

            studentDTOList.add(studentDTO);
        }
        return studentDTOList;
    }

    @Override
    public boolean insertStudent(MultipartFile file, String studentCode, String password, String studentName, String email, String phone, String address, boolean status, String admissionDate, String graduationDate, int departmentId, int classId){
        boolean insertSuccess = false;

        try {
            boolean saveFileSuccess = fileServiceImp.saveFile(file);

            if (saveFileSuccess){
                Students students = new Students();

//                students.setStudentCode(studentRequest.getStudentCode());
//                students.setPassword(studentRequest.getPassword());
//                students.setStudentName(studentRequest.getStudentName());
//                students.setEmail(studentRequest.getEmail());
//                students.setPhone(studentRequest.getPhone());
//                students.setAddress(studentRequest.getAddress());
//                students.setStatus(studentRequest.isStatus());
//
//                SimpleDateFormat admissionDateFormat = new SimpleDateFormat("dd/mm/yyyy");
//                Date admission_date = admissionDateFormat.parse(studentRequest.getAdmissionDate());
//                students.setAdmissionDate(admission_date);
//
//                SimpleDateFormat graduationDateFormat = new SimpleDateFormat();
//                Date graduation_date = graduationDateFormat.parse(studentRequest.getGraduationDate());
//                students.setGraduationDate(graduation_date);
//
//                Departments departments = new Departments();
//                departments.setId(studentRequest.getDepartmentId());
//
//                Classes classes = new Classes();
//                classes.setId(studentRequest.getClassId());

                students.setStudentCode(studentCode);
                students.setPassword(password);
                students.setStudentName(studentName);
                students.setEmail(email);
                students.setPhone(phone);
                students.setAddress(address);
                students.setStatus(status);

                SimpleDateFormat admissionDateFormat = new SimpleDateFormat("yyyy-mm-dd");
                Date admission_date = admissionDateFormat.parse(admissionDate);
                students.setAdmissionDate(admission_date);

                SimpleDateFormat graduationDateFormat = new SimpleDateFormat("yyyy-mm-dd");
                Date graduation_date = graduationDateFormat.parse(graduationDate);
                students.setGraduationDate(graduation_date);

                Departments departments = new Departments();
                departments.setId(departmentId);

                Classes classes = new Classes();
                classes.setId(classId);

                studentRepository.save(students);
                insertSuccess = true;
            }
        } catch (Exception e){
            System.out.println("Insert failed!");
            e.printStackTrace();
        }
        return insertSuccess;
    }

    @Override
    public boolean updateStudent(int id, MultipartFile file, String studentCode, String password, String studentName, String email, String phone, String address, boolean status, String admissionDate, String graduationDate, int departmentId, int classId) {
        boolean updateSuccess = false;

        try {
            Optional<Students> optionalStudents = studentRepository.findById(id);

            if (optionalStudents.isPresent()) {
                boolean saveFileSuccess = fileServiceImp.saveFile(file);
                if (saveFileSuccess) {
                    Students students = optionalStudents.get();

                    students.setStudentCode(studentCode);
                    students.setPassword(password);
                    students.setStudentName(studentName);
                    students.setEmail(email);
                    students.setPhone(phone);
                    students.setAddress(address);
                    students.setStatus(status);

                    SimpleDateFormat admissionDateFormat = new SimpleDateFormat("yyyy-mm-dd");
                    Date admission_date = admissionDateFormat.parse(admissionDate);
                    students.setAdmissionDate(admission_date);

                    SimpleDateFormat graduationDateFormat = new SimpleDateFormat("yyyy-mm-dd");
                    Date graduation_date = graduationDateFormat.parse(graduationDate);
                    students.setGraduationDate(graduation_date);

                    Departments departments = new Departments();
                    departments.setId(departmentId);
                    students.setDepartmentId(departments);

                    Classes classes = new Classes();
                    classes.setId(classId);
                    students.setClassId(classes);

                    studentRepository.save(students);
                    updateSuccess = true;
                }
            }
        } catch (Exception e){
            System.out.println("Update failed!");
            e.printStackTrace();
        }
        return updateSuccess;
    }

    @Override
    public boolean deleteStudent(int id) {
        boolean deleteSuccess = false;

        try {
            studentRepository.deleteById(id);
            deleteSuccess = true;
        } catch (Exception e) {
            System.out.println("Student not found with id " + id);
        }
        return deleteSuccess;
    }

    @Override
    public List<StudentDTO> searchStudentByEmail(String email) {

        List<Students> studentList = studentRepository.findByEmailContaining(email);
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Students students : studentList) {
            StudentDTO studentDTO = new StudentDTO();

            studentDTO.setStudentCode(students.getStudentCode());
            studentDTO.setPassword(students.getPassword());
            studentDTO.setStudentName(students.getStudentName());
            studentDTO.setImage(students.getImage());
            studentDTO.setEmail(students.getEmail());
            studentDTO.setPhone(students.getPhone());
            studentDTO.setAddress(students.getAddress());
            studentDTO.setStatus(students.isStatus());
            studentDTO.setAdmissionDate(students.getAdmissionDate());
            studentDTO.setGraduationDate(students.getGraduationDate());
            studentDTO.setDepartmentId(students.getDepartmentId().getId());
            studentDTO.setClassId(students.getClassId().getId());

            studentDTOList.add(studentDTO);
        }
        return studentDTOList;
    }

    @Override
    public List<StudentDTO> searchStudentByStudentCode(String code) {
        List<Students> studentList = studentRepository.findByStudentCodeContaining(code);
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Students students : studentList) {
            StudentDTO studentDTO = new StudentDTO();

            studentDTO.setStudentCode(students.getStudentCode());
            studentDTO.setPassword(students.getPassword());
            studentDTO.setStudentName(students.getStudentName());
            studentDTO.setImage(students.getImage());
            studentDTO.setEmail(students.getEmail());
            studentDTO.setPhone(students.getPhone());
            studentDTO.setAddress(students.getAddress());
            studentDTO.setStatus(students.isStatus());
            studentDTO.setAdmissionDate(students.getAdmissionDate());
            studentDTO.setGraduationDate(students.getGraduationDate());
            studentDTO.setDepartmentId(students.getDepartmentId().getId());
            studentDTO.setClassId(students.getClassId().getId());

            studentDTOList.add(studentDTO);
        }
        return studentDTOList;
    }

    @Override
    public List<StudentDTO> searchStudentByPhone(String phone) {
        List<Students> studentList = studentRepository.findByPhoneContaining(phone);
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Students students : studentList) {
            StudentDTO studentDTO = new StudentDTO();

            studentDTO.setStudentCode(students.getStudentCode());
            studentDTO.setPassword(students.getPassword());
            studentDTO.setStudentName(students.getStudentName());
            studentDTO.setImage(students.getImage());
            studentDTO.setEmail(students.getEmail());
            studentDTO.setPhone(students.getPhone());
            studentDTO.setAddress(students.getAddress());
            studentDTO.setStatus(students.isStatus());
            studentDTO.setAdmissionDate(students.getAdmissionDate());
            studentDTO.setGraduationDate(students.getGraduationDate());
            studentDTO.setDepartmentId(students.getDepartmentId().getId());
            studentDTO.setClassId(students.getClassId().getId());

            studentDTOList.add(studentDTO);
        }
        return studentDTOList;
    }
}
