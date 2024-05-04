package com.severusnguyen.schoolmangagement.reposirory;

import com.severusnguyen.schoolmangagement.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Students, Integer> {
    List<Students> findByEmailContaining(String search);
    List<Students> findByStudentCodeContaining(String email);
    List<Students> findByPhoneContaining(String phone);
    Students findByStudentCodeAndPassword(String code, String password);
    Students findByStudentCode(String username);
}
