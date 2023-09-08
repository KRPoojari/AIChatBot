package com.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rest.entity.EmployeeEntity;
import com.rest.entity.EmployeeQuestionnaireEntity;

/*public interface EmpQuestionnaireRepository extends JpaRepository<EmployeeQuestionnaireEntity, Integer>  {

    @Query("select u from EmployeeQuestionnaireEntity u where u.question = :question")
    public EmployeeQuestionnaireEntity searchByQuestion(@Param("question") String question);

    @Query("select u.keyword from EmployeeQuestionnaireEntity u where u.question = :question")
    public String searchByRootWord(@Param("question") String question);
}*/
public interface EmpQuestionnaireRepository extends JpaRepository<EmployeeQuestionnaireEntity, Long> {

    @Query(value = "SELECT keyword FROM emp_info_questionnaire WHERE question = :question", nativeQuery = true)
    String findKeywordByQuestion(String question);
}
