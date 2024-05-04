package com.severusnguyen.schoolmangagement.service;

import com.severusnguyen.schoolmangagement.dto.StudentDTO;
import com.severusnguyen.schoolmangagement.dto.TeacherDTO;
import com.severusnguyen.schoolmangagement.entity.Departments;
import com.severusnguyen.schoolmangagement.entity.Students;
import com.severusnguyen.schoolmangagement.entity.Teachers;
import com.severusnguyen.schoolmangagement.payload.request.TeacherRequest;
import com.severusnguyen.schoolmangagement.reposirory.TeacherRepository;
import com.severusnguyen.schoolmangagement.service.imp.FileServiceImp;
import com.severusnguyen.schoolmangagement.service.imp.TeacherServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService implements TeacherServiceImp {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    FileServiceImp fileServiceImp;

    @Override
    public List<TeacherDTO> getAllTeacher() {
        //List<Teachers> teachersList = teacherRepository.findAll();
        List<TeacherDTO> teacherDTOList = new ArrayList<>();
        PageRequest pageRequest = PageRequest.of(0, 6); //trang x, tổng dữ liệu là x
        //teacherRepository.findAll(pageRequest);
        Page<Teachers> teachersList = teacherRepository.findAll(pageRequest);

        for (Teachers teachers : teachersList) {
            TeacherDTO teacherDTO = new TeacherDTO();

            teacherDTO.setTeacherCode(teachers.getTeacherCode());
            teacherDTO.setTeacherName(teachers.getTeacherName());
            teacherDTO.setPassword(teachers.getPassword());
            teacherDTO.setEmail(teachers.getEmail());
            teacherDTO.setPhone(teachers.getPhone());
            teacherDTO.setAddress(teachers.getAddress());
            teacherDTO.setStartDate(teachers.getStart_date());
            teacherDTO.setDepartmentId(teachers.getDepartmentId().getId());


            teacherDTOList.add(teacherDTO);
        }
        return teacherDTOList;
    }

    @Override
    public boolean insertTeacher(MultipartFile file,
                                 String teacherCode,
                                 String password,
                                 String teacherName,
                                 String email,
                                 String phone,
                                 String address,
                                 String startDate,
                                 int departmentId) {
        boolean insertSuccess = false;

        try {
            boolean saveFileSuccess = fileServiceImp.saveFile(file);
            if (saveFileSuccess) {
                Teachers teachers = new Teachers();

//                teachers.setTeacherCode(teacherRequest.getTeacherCode());
//                teachers.setPassword(teacherRequest.getPassword());
//                teachers.setTeacherName(teacherRequest.getTeacherName());
//                teachers.setEmail(teacherRequest.getEmail());
//                teachers.setPhone(teacherRequest.getPhone());
//                teachers.setAddress(teacherRequest.getAddress());
//                SimpleDateFormat startDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//                Date start_Date = startDateFormat.parse(teacherRequest.getStartDate());
//                teachers.setStart_date(start_Date);
//                Departments departments = new Departments();
//                departments.setId(teacherRequest.getDepartmentId());

                teachers.setTeacherCode(teacherCode);
                teachers.setPassword(password);
                teachers.setTeacherName(teacherName);
                teachers.setEmail(email);
                teachers.setPhone(phone);
                teachers.setAddress(address);
                SimpleDateFormat startDateFormat = new SimpleDateFormat("yyyy-mm-dd");
                Date start_Date = startDateFormat.parse(startDate);
                teachers.setStart_date(start_Date);
                Departments departments = new Departments();
                departments.setId(departmentId);
                teachers.setDepartmentId(departments);

                teacherRepository.save(teachers);
                insertSuccess = true;
            }
        } catch (Exception e) {
            System.out.println("Insert failed!");
            e.printStackTrace();
        }

        return insertSuccess;
    }

    @Override
    public boolean updateTeacher(int id,
                                 MultipartFile file,
                                 String teacherCode,
                                 String password,
                                 String teacherName,
                                 String email,
                                 String phone,
                                 String address,
                                 String startDate,
                                 int departmentId) {
        boolean updateSuccess = false;

        try {
            boolean saveFileSuccess = fileServiceImp.saveFile(file);
            Optional<Teachers> optionalTeachers = teacherRepository.findById(id);
            if (optionalTeachers.isPresent()) {
                if (saveFileSuccess) {
                    Teachers teachers = optionalTeachers.get();

//                teachers.setTeacherCode(teacherRequest.getTeacherCode());
//                teachers.setPassword(teacherRequest.getPassword());
//                teachers.setTeacherName(teacherRequest.getTeacherName());
//                teachers.setEmail(teacherRequest.getEmail());
//                teachers.setPhone(teacherRequest.getPhone());
//                teachers.setAddress(teacherRequest.getAddress());
//                SimpleDateFormat startDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//                Date start_Date = startDateFormat.parse(teacherRequest.getStartDate());
//                teachers.setStart_date(start_Date);
//                Departments departments = new Departments();
//                departments.setId(teacherRequest.getDepartmentId());

                    teachers.setTeacherCode(teacherCode);
                    teachers.setPassword(password);
                    teachers.setTeacherName(teacherName);
                    teachers.setEmail(email);
                    teachers.setPhone(phone);
                    teachers.setAddress(address);
                    SimpleDateFormat startDateFormat = new SimpleDateFormat("yyyy-mm-dd");
                    Date start_Date = startDateFormat.parse(startDate);
                    teachers.setStart_date(start_Date);
                    Departments departments = new Departments();
                    departments.setId(departmentId);

                    teacherRepository.save(teachers);
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
    public boolean deleteTeacher(int id) {
        boolean deleteSuccess = false;

        try {
            teacherRepository.deleteById(id);
            deleteSuccess = true;
        } catch (Exception e){
            System.out.println("Teacher not found with id: " + id);

        }
        return deleteSuccess;
    }

    @Override
    public List<TeacherDTO> searchTeacherByEmail(String email) {
        List<Teachers> teachersList = teacherRepository.findByEmailContaining(email);
        List<TeacherDTO> teacherDTOList = new ArrayList<>();
        for (Teachers teachers : teachersList) {
            TeacherDTO teacherDTO = new TeacherDTO();

            teacherDTO.setTeacherCode(teachers.getTeacherCode());
            teacherDTO.setTeacherName(teachers.getTeacherName());
            teacherDTO.setPassword(teachers.getPassword());
            teacherDTO.setEmail(teachers.getEmail());
            teacherDTO.setPhone(teachers.getPhone());
            teacherDTO.setAddress(teachers.getAddress());
            teacherDTO.setStartDate(teachers.getStart_date());
            teacherDTO.setDepartmentId(teachers.getDepartmentId().getId());

            teacherDTOList.add(teacherDTO);
        }
        return teacherDTOList;
    }

    @Override
    public TeacherDTO searchTeacherByTeacherCode(String code) {
        Teachers teachers = teacherRepository.findByTeacherCodeContaining(code);
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setTeacherCode(teachers.getTeacherCode());
        teacherDTO.setTeacherName(teachers.getTeacherName());
        teacherDTO.setPassword(teachers.getPassword());
        teacherDTO.setEmail(teachers.getEmail());
        teacherDTO.setPhone(teachers.getPhone());
        teacherDTO.setAddress(teachers.getAddress());
        teacherDTO.setStartDate(teachers.getStart_date());
        teacherDTO.setDepartmentId(teachers.getDepartmentId().getId());
        return teacherDTO;
    }
}
