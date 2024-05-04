package com.severusnguyen.schoolmangagement.service;

import com.severusnguyen.schoolmangagement.dto.SubjectDTO;
import com.severusnguyen.schoolmangagement.entity.Subjects;
import com.severusnguyen.schoolmangagement.entity.Teachers;
import com.severusnguyen.schoolmangagement.payload.request.SubjectRequest;
import com.severusnguyen.schoolmangagement.reposirory.SubjectRepository;
import com.severusnguyen.schoolmangagement.service.imp.FileServiceImp;
import com.severusnguyen.schoolmangagement.service.imp.SubjectServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectService implements SubjectServiceImp {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    FileServiceImp fileServiceImp;

    @Override
    public List<SubjectDTO> getAllSubject() {
        List<Subjects> subjectsList = subjectRepository.findAll();
        List<SubjectDTO> subjectDTOList = new ArrayList<>();

        for (Subjects subjects : subjectsList) {
            SubjectDTO subjectDTO = new SubjectDTO();

            subjectDTO.setSubjectCode(subjects.getSubjects_code());
            subjectDTO.setSubjectName(subjects.getSubjectsName());
            subjectDTO.setCredit(subjects.getCredits());
            subjectDTO.setTeacherId(subjects.getTeacherId().getId());

            subjectDTOList.add(subjectDTO);
        }
        return subjectDTOList;
    }

    @Override
    public boolean insertSubject(SubjectRequest subjectRequest) {
        boolean insertSuccess = false;

        try {
            Subjects subjects = new Subjects();

            subjects.setSubjects_code(subjectRequest.getSubjectCode());
            subjects.setSubjectsName(subjectRequest.getSubjectName());
            subjects.setCredits(subjectRequest.getCredit());

            Teachers teachers = new Teachers();
            teachers.setId(subjectRequest.getTeacherId());
            subjects.setTeachersId(teachers);

            subjectRepository.save(subjects);
            insertSuccess = true;
        } catch (Exception e){
            System.out.println("Insert failed!");
            e.printStackTrace();
        }
        return insertSuccess;
    }

    @Override
    public boolean updateSubject(int id, SubjectRequest subjectRequest) {
        boolean updateSuccess = false;

        try {
            Optional<Subjects> subjectsOptional = subjectRepository.findById(id);
            if (subjectsOptional.isPresent()){
                Subjects subjects = subjectsOptional.get();

                subjects.setSubjects_code(subjectRequest.getSubjectCode());
                subjects.setSubjectsName(subjectRequest.getSubjectName());
                subjects.setCredits(subjectRequest.getCredit());

                Teachers teachers = new Teachers();
                teachers.setId(subjectRequest.getTeacherId());
                subjects.setTeachersId(teachers);

                subjectRepository.save(subjects);
                updateSuccess = true;
            }
        } catch (Exception e) {
            System.out.println("Update failed!");
            e.printStackTrace();
        }

        return updateSuccess;
    }

    @Override
    public boolean deleteSubject(int id) {
        boolean deleteSuccess = false;

        try {
            subjectRepository.deleteById(id);
            deleteSuccess = true;
        } catch (Exception e) {
            System.out.println("Delete failed!");
            e.printStackTrace();
        }
        return deleteSuccess;
    }
}
