package com.severusnguyen.schoolmangagement.service;

import com.severusnguyen.schoolmangagement.dto.ClassDTO;
import com.severusnguyen.schoolmangagement.entity.Classes;
import com.severusnguyen.schoolmangagement.entity.Departments;
import com.severusnguyen.schoolmangagement.entity.Teachers;
import com.severusnguyen.schoolmangagement.payload.request.ClassRequest;
import com.severusnguyen.schoolmangagement.reposirory.ClassRepository;
import com.severusnguyen.schoolmangagement.service.imp.ClassServiceImp;
import com.severusnguyen.schoolmangagement.service.imp.FileServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClassService implements ClassServiceImp {

    @Autowired
    ClassRepository classRepository;

    @Autowired
    FileServiceImp fileServiceImp;

    @Override
    public List<ClassDTO> getAllClass() {

        List<Classes> classesList = classRepository.findAll();
        List<ClassDTO> classDTOList = new ArrayList<>();

        for (Classes classes : classesList) {
            ClassDTO classDTO = new ClassDTO();

            classDTO.setClassName(classes.getClassName());
            classDTO.setAmountStudent(classes.getAmountStudent());
            classDTO.setClassHead(classes.getClassHead());
            classDTO.setHomeroomTeacher(classes.getHomeroomTeacher());

            Teachers teachers = new Teachers();
            teachers.setId(classes.getId());
            classDTO.setTeacherId(teachers.getId());

            classDTOList.add(classDTO);

        }
        return classDTOList;
    }

    @Override
    public boolean insertClass(ClassRequest classRequest) {
        boolean insertSuccess = false;

        try {
            Classes classes = new Classes();

            classes.setClassName(classRequest.getClassName());
            classes.setAmountStudent(classRequest.getAmountStudent());
            classes.setClassHead(classRequest.getClassHead());
            classes.setHomeroomTeacher(classRequest.getHomeroomTeacher());

            Teachers teachers = new Teachers();
            teachers.setId(classRequest.getTeacherId());
            classes.setTeacher(teachers);

            classRepository.save(classes);
            insertSuccess = true;
        } catch (Exception e){
            System.out.println("Insert failed!");
            e.printStackTrace();
        }
        return insertSuccess;
    }

    @Override
    public boolean updateClass(int id, ClassRequest classRequest) {
        boolean updateSuccess = false;

        try {
            Optional<Classes> classesOptional = classRepository.findById(id);

            if (classesOptional.isPresent()){
                boolean saveFileSuccess = fileServiceImp.saveFile(classRequest.getFile());
                if (saveFileSuccess) {
                    Classes classes = classesOptional.get();

                    classes.setClassName(classRequest.getClassName());
                    classes.setAmountStudent(classRequest.getAmountStudent());
                    classes.setClassHead(classRequest.getClassHead());
                    classes.setHomeroomTeacher(classRequest.getHomeroomTeacher());

                    Teachers teachers = new Teachers();
                    teachers.setId(classRequest.getTeacherId());
                    classes.setTeacher(teachers);

                    classRepository.save(classes);
                    updateSuccess = true;
                }
            }
        } catch (Exception e){
            System.out.println("Update fail!");
            e.printStackTrace();
        }
        return updateSuccess;
    }

    @Override
    public boolean deleteClass(int id) {
        boolean deleteSuccess = false;

        try {
            classRepository.deleteById(id);
            deleteSuccess = true;
        } catch (Exception e){
            System.out.println("Delete failed!");
            e.printStackTrace();
        }
        return deleteSuccess;
    }
}
