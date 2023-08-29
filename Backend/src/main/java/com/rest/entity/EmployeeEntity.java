package com.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="emp_information")
public class EmployeeEntity {

    @Id
    @Column(name = "emp_id")
    private String empId;
    @Column(name = "emp_name")
    private String empName;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "emp_role")
    private String empRole;
    @Column(name = "manager_name")
    private String managerName;
    @Column(name = "chapter_name")
    private String chapterName;
    @Column(name = "location")
    private String location;
    @Column(name = "nwa_code")
    private String nwaCode;

    @Column(name = "phone")
    private String phoneNo;

    @Column(name = "onboarding_status")
    private String onBoardingStatus;
    public String getNwaCode() {
        return nwaCode;
    }

    public void setNwaCode(String nwaCode) {
        this.nwaCode = nwaCode;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getEmpRole() {
        return empRole;
    }

    public void setEmpRole(String empRole) {
        this.empRole = empRole;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String locationName) {
        this.location = locationName;
    }
    public String getPhone() {
        return phoneNo;
    }

    public void setPhone(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getOnBoardingStatus() {
        return onBoardingStatus;
    }

    public void setOnBoardingStatus(String onBoardingStatus) {
        this.onBoardingStatus = onBoardingStatus;
    }
}
