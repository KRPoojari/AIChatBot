package com.example.postman.repository;

import com.example.postman.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

    @Query("select u from EmployeeEntity u where u.empId = :empId")
    public EmployeeEntity searchByEmpId(@Param("empId") String empId);

    /*@Query("select u.keyword from EmployeeEntity u where u.keyword = :keyword")
    public String getAnswer(@Param("keyword") String keyword);*/

}

