package com.severusnguyen.schoolmangagement.reposirory;

import com.severusnguyen.schoolmangagement.entity.Students;
import com.severusnguyen.schoolmangagement.entity.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teachers, Integer> {
    List<Teachers> findByEmailContaining(String search);
    Teachers findByTeacherCodeContaining(String code);
}
