package com.example.postman.repository;

import com.example.postman.entity.CompanyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails,Integer> {
    @Query("select u from CompanyDetails u where u.file_name = :file_name")
    public CompanyDetails searchByFileName(@Param("file_name") String file_name);
}
