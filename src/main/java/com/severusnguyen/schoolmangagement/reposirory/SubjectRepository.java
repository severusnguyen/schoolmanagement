package com.severusnguyen.schoolmangagement.reposirory;

import com.severusnguyen.schoolmangagement.entity.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface SubjectRepository extends JpaRepository<Subjects, Integer> {

}
