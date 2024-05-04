package com.severusnguyen.schoolmangagement.service;

import com.severusnguyen.schoolmangagement.dto.DepartmentDTO;
import com.severusnguyen.schoolmangagement.dto.TeacherDTO;
import com.severusnguyen.schoolmangagement.entity.Departments;
import com.severusnguyen.schoolmangagement.entity.Teachers;
import com.severusnguyen.schoolmangagement.payload.request.DepartmentRequest;
import com.severusnguyen.schoolmangagement.reposirory.DepartmentRepository;
import com.severusnguyen.schoolmangagement.service.imp.DepartmentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements DepartmentServiceImp {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentDTO> getAllDepartment() {

        //List<Departments> departmentsList = departmentRepository.findAll();
        List<DepartmentDTO> departmentDTOList = new ArrayList<>();
        PageRequest pageRequest = PageRequest.of(0, 6); //trang x, tổng dữ liệu là x
        //departmentRepository.findAll(pageRequest);
        Page<Departments> departmentsList = departmentRepository.findAll(pageRequest);

        for ( Departments departments : departmentsList) {
            DepartmentDTO departmentDTO = new DepartmentDTO();

            departmentDTO.setId(departments.getId());
            departmentDTO.setDepartmentCode(departments.getDepartmentCode());
            departmentDTO.setDepartmentName(departments.getDepartmentName());
            departmentDTO.setDepartmentHead(departments.getDepartmentHead());
            departmentDTO.setDepartmentDesc(departments.getDepartmentDesc());

            departmentDTOList.add(departmentDTO);
        }
        return departmentDTOList;
    }

    @Override
    public boolean insertTeacher(DepartmentRequest departmentRequest) {

        boolean insertSuccess = false;

        try {
            Departments departments = new Departments();

            departments.setDepartmentCode(departmentRequest.getDepartmentCode());
            departments.setDepartmentName(departmentRequest.getDepartmentName());
            departments.setDepartmentHead(departmentRequest.getDepartmentHead());
            departments.setDepartmentDesc(departmentRequest.getDepartmentDesc());

            departmentRepository.save(departments);
            insertSuccess = true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return insertSuccess;
    }

    @Override
    public boolean updateDepartment(int id, DepartmentRequest departmentRequest) {
        boolean updateSuccess = false;
        try {
            Optional<Departments> optionalDepartment = departmentRepository.findById(id);

            if (optionalDepartment.isPresent()) {
                Departments department = optionalDepartment.get();

                department.setDepartmentCode(departmentRequest.getDepartmentCode());
                department.setDepartmentName(departmentRequest.getDepartmentName());
                department.setDepartmentDesc(departmentRequest.getDepartmentDesc());
                department.setDepartmentHead(departmentRequest.getDepartmentHead());

                departmentRepository.save(department);
                updateSuccess = true;
            } else {
                System.out.println("Department not found with id: " + id);
            }
        } catch (Exception e){
            System.out.println("An error occurred while updating department with id: " + id);
        }
        return updateSuccess;
    }

    @Override
    public boolean deleteDepartment(int id) {
        boolean deleteSuccess = false;

        try {
            departmentRepository.deleteById(id);
            deleteSuccess = true;
        } catch (Exception e){
            System.out.println("Department not found with id: " + id);
        }

        return deleteSuccess;
    }

    @Override
    public List<DepartmentDTO> searchDepartmentByCode(String code) {
        List<Departments> departmentsList = departmentRepository.findByDepartmentCodeContaining(code);
        List<DepartmentDTO> departmentDTOList = new ArrayList<>();
        for ( Departments departments : departmentsList) {
            DepartmentDTO departmentDTO = new DepartmentDTO();

            departmentDTO.setId(departments.getId());
            departmentDTO.setDepartmentCode(departments.getDepartmentCode());
            departmentDTO.setDepartmentName(departments.getDepartmentName());
            departmentDTO.setDepartmentHead(departments.getDepartmentHead());
            departmentDTO.setDepartmentDesc(departments.getDepartmentDesc());

            departmentDTOList.add(departmentDTO);
        }
        return departmentDTOList;
    }
}
