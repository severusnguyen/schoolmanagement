package com.severusnguyen.schoolmangagement.service.imp;

import com.severusnguyen.schoolmangagement.dto.ClassDTO;
import com.severusnguyen.schoolmangagement.payload.request.ClassRequest;

import java.util.List;

public interface ClassServiceImp {
    List<ClassDTO> getAllClass();
    boolean insertClass(ClassRequest classRequest);
    boolean updateClass(int id, ClassRequest classRequest);
    boolean deleteClass(int id);
}
