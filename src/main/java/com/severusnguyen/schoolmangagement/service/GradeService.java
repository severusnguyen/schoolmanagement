package com.severusnguyen.schoolmangagement.service;

import com.severusnguyen.schoolmangagement.dto.GradeDTO;
import com.severusnguyen.schoolmangagement.dto.StudentDTO;
import com.severusnguyen.schoolmangagement.dto.SubjectDTO;
import com.severusnguyen.schoolmangagement.entity.Grades;
import com.severusnguyen.schoolmangagement.entity.Students;
import com.severusnguyen.schoolmangagement.entity.Subjects;
import com.severusnguyen.schoolmangagement.payload.request.GradeRequest;
import com.severusnguyen.schoolmangagement.reposirory.GradeRepository;
import com.severusnguyen.schoolmangagement.service.imp.GradeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GradeService implements GradeServiceImp {

    @Autowired
    GradeRepository gradeRepository;

    @Override
    public List<GradeDTO> getAllGrade() {
        List<Grades> gradesList = gradeRepository.findAll();
        List<GradeDTO> gradeDTOList = new ArrayList<>();

        for (Grades grades : gradesList) {
            GradeDTO gradeDTO = new GradeDTO();

            Students students = new Students();
            students.setId(grades.getStudentId().getId());
            gradeDTO.setStudentId(students);

            Subjects subjects = new Subjects();
            students.setId(grades.getSubjectId().getId());
            gradeDTO.setSubjectId(subjects);

            gradeDTO.setGrade(grades.getGrade());
            gradeDTO.setGradeType(grades.getGradeType());
            gradeDTO.setGradeDate(grades.getGradeDate());

            gradeDTOList.add(gradeDTO);
        }
        return gradeDTOList;
    }

    @Override
    public boolean insertGrade(GradeRequest gradeRequest) {
        boolean insertSuccess = false;

        try {
            Grades grades = new Grades();

            Students students = new Students();
            students.setId(gradeRequest.getStudentId());
            grades.setStudentId(students);

            Subjects subjects = new Subjects();
            subjects.setId(gradeRequest.getSubjectId());
            grades.setSubjectId(subjects);

            grades.setGrade(gradeRequest.getGrade());
            grades.setGradeType(gradeRequest.getGradeType());

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
            Date grade_date = simpleDateFormat.parse(gradeRequest.getGradeDate());
            grades.setGradeDate(grade_date);

            gradeRepository.save(grades);
            insertSuccess = true;

        } catch (Exception e) {
            System.out.println("Insert failed!");
            e.printStackTrace();
        }
        return insertSuccess;
    }

    @Override
    public boolean updateGrade(int id, GradeRequest gradeRequest) {
        boolean updateSuccess = false;

        try {
            Optional<Grades> optionalGrades = gradeRepository.findById(id);
            if (optionalGrades.isPresent()) {
                Grades grades = optionalGrades.get();

                Students students = new Students();
                students.setId(gradeRequest.getStudentId());
                grades.setStudentId(students);

                Subjects subjects = new Subjects();
                subjects.setId(gradeRequest.getSubjectId());
                grades.setSubjectId(subjects);

                grades.setGrade(gradeRequest.getGrade());
                grades.setGradeType(gradeRequest.getGradeType());

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
                Date grade_date = simpleDateFormat.parse(gradeRequest.getGradeDate());
                grades.setGradeDate(grade_date);

                gradeRepository.save(grades);
                updateSuccess = true;
            }
        } catch (Exception e) {
            System.out.println("Update failed!");
            e.printStackTrace();
        }
        return updateSuccess;
    }

    @Override
    public boolean deleteGrade(int id) {
        boolean deleteSuccess = false;

        try {
            gradeRepository.deleteById(id);
            deleteSuccess = true;
        } catch (Exception e) {
            System.out.println("Delete Failed!");
            e.printStackTrace();
        }
        return deleteSuccess;
    }

    @Override
    public List<GradeDTO> findByGradeType(String type) {
        List<Grades> gradesList = gradeRepository.findByGradeTypeContaining(type);
        List<GradeDTO> gradeDTOList = new ArrayList<>();

        for (Grades grades : gradesList) {
            GradeDTO gradeDTO = new GradeDTO();

            gradeDTO.setStudentId(grades.getStudentId());
            gradeDTO.setSubjectId(grades.getSubjectId());
            gradeDTO.setGrade(grades.getGrade());
            gradeDTO.setGradeType(grades.getGradeType());
            gradeDTO.setGradeDate(grades.getGradeDate());

            gradeDTOList.add(gradeDTO);
        }
        return gradeDTOList;
    }

    @Override
    public List<GradeDTO> findByGradeGreaterThan(float grade) {
        List<Grades> gradesList = gradeRepository.findByGradeGreaterThan(grade);
        List<GradeDTO> gradeDTOList = new ArrayList<>();

        for (Grades grades : gradesList) {
            GradeDTO gradeDTO = new GradeDTO();

            gradeDTO.setStudentId(grades.getStudentId());
            gradeDTO.setSubjectId(grades.getSubjectId());
            gradeDTO.setGrade(grades.getGrade());
            gradeDTO.setGradeType(grades.getGradeType());
            gradeDTO.setGradeDate(grades.getGradeDate());

            gradeDTOList.add(gradeDTO);
        }
        return  gradeDTOList;
    }
}
