package com.severusnguyen.schoolmangagement.service.imp;

import com.severusnguyen.schoolmangagement.dto.SubjectDTO;
import com.severusnguyen.schoolmangagement.payload.request.SubjectRequest;

import java.util.List;

public interface SubjectServiceImp {
    List<SubjectDTO> getAllSubject();
    boolean insertSubject(SubjectRequest subjectRequest);
    boolean updateSubject(int id, SubjectRequest subjectRequest);
    boolean deleteSubject(int id);

}
