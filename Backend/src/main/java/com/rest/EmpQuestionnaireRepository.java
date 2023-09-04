package com.example.postman.repository;

import com.example.postman.entity.EmployeeEntity;
import com.example.postman.entity.EmployeeQuestionnaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmpQuestionnaireRepository extends JpaRepository<EmployeeQuestionnaireEntity, Integer>  {

    @Query("select u from EmployeeQuestionnaireEntity u where u.question = :question")
    public EmployeeQuestionnaireEntity searchByQuestion(@Param("question") String question);

    @Query("select u.keyword from EmployeeQuestionnaireEntity u where u.question = :question")
    public String searchByRootWord(@Param("question") String question);
}
