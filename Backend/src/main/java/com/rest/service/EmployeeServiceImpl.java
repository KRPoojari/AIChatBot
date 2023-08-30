package com.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.rest.entity.EmployeeEntity;
import com.rest.repository.EmployeeRepository;
import com.rest.responseModel.ResponseEntity;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

     public EmployeeEntity saveEntity(EmployeeEntity employeeEntity){
        return employeeRepository.save(employeeEntity);
    }

    public List<EmployeeEntity> getAll() {
         return employeeRepository.findAll();
    }

    @Override
    public ResponseEntity checkEmpId(String empId) {
        ResponseEntity responseEntity=new ResponseEntity();
        EmployeeEntity employeeEntity = employeeRepository.searchByEmpId(empId);
        String message = "Proceed..";
        if(employeeEntity == null){
            message = "Provided Employee Id is incorrect!!";
        }
        responseEntity.setResult(message);
        return responseEntity;
    }

}
