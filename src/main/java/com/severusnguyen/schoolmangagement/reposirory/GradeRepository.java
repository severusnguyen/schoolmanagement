package com.severusnguyen.schoolmangagement.reposirory;

import com.severusnguyen.schoolmangagement.dto.GradeDTO;
import com.severusnguyen.schoolmangagement.entity.Grades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grades, Integer> {
    List<Grades> findByGradeGreaterThan(float grade);
    List<Grades> findByGradeTypeContaining(String type);
}
