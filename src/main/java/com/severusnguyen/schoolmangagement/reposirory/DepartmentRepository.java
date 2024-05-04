package com.severusnguyen.schoolmangagement.reposirory;

import com.severusnguyen.schoolmangagement.dto.DepartmentDTO;
import com.severusnguyen.schoolmangagement.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Departments, Integer> {
    List<Departments> findByDepartmentCodeContaining(String code);

}
