package com.severusnguyen.schoolmangagement.service.imp;

import com.severusnguyen.schoolmangagement.dto.DepartmentDTO;
import com.severusnguyen.schoolmangagement.payload.request.DepartmentRequest;

import java.util.List;

public interface DepartmentServiceImp {
    List<DepartmentDTO> getAllDepartment();
    boolean insertTeacher(DepartmentRequest departmentRequest);

    boolean updateDepartment(int id, DepartmentRequest departmentRequest);

    boolean deleteDepartment(int id);

    List<DepartmentDTO> searchDepartmentByCode(String code);
}
