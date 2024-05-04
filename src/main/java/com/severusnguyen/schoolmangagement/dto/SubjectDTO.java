package com.severusnguyen.schoolmangagement.dto;

import com.severusnguyen.schoolmangagement.entity.Teachers;
import lombok.Data;

@Data
public class SubjectDTO {
    private String subjectName;
    private String subjectCode;
    private int credit;
    private int teacherId;

}
