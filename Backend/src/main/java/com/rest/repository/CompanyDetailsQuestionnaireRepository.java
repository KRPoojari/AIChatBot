package com.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.entity.CompanyDetailsQuestionnaire;

@Repository
public interface CompanyDetailsQuestionnaireRepository extends JpaRepository<CompanyDetailsQuestionnaire,Integer> {
    @Query("select u from CompanyDetailsQuestionnaire u where u.question = :question")
    public CompanyDetailsQuestionnaire searchByQuestion(@Param("question") String question);

    @Query("select u.keyword from CompanyDetailsQuestionnaire u where u.question = :question")
    public String searchByRootWord(@Param("question") String question);
}
