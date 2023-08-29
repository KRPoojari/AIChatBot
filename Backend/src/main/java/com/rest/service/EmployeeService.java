package com.rest.service;

import java.util.List;

import com.rest.entity.EmployeeEntity;
import com.rest.responseModel.ResponseEntity;

public interface EmployeeService {
    public EmployeeEntity saveEntity(EmployeeEntity employeeEntity);
    public List<EmployeeEntity> getAll();
    public ResponseEntity checkEmpId(String empId);
}
