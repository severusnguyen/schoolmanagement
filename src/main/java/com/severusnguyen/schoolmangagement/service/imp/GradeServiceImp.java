package com.severusnguyen.schoolmangagement.service.imp;

import com.severusnguyen.schoolmangagement.dto.GradeDTO;
import com.severusnguyen.schoolmangagement.dto.SubjectDTO;
import com.severusnguyen.schoolmangagement.payload.request.GradeRequest;
import com.severusnguyen.schoolmangagement.payload.request.SubjectRequest;

import java.util.List;

public interface GradeServiceImp {
    List<GradeDTO> getAllGrade();
    boolean insertGrade(GradeRequest gradeRequest);
    boolean updateGrade(int id, GradeRequest gradeRequest);
    boolean deleteGrade(int id);
    List<GradeDTO> findByGradeType(String type);
    List<GradeDTO> findByGradeGreaterThan(float grade);
}
