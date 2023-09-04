package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import com.rest.entity.EmployeeEntity;
import com.rest.exception.IncompleteDetailsProvided;
import com.rest.responseModel.ResponseEntity;
import com.rest.service.EmployeeService;
import com.rest.service.EmployeeServiceImpl;

import java.util.List;

@RestController
@EnableAutoConfiguration
@CrossOrigin("http://localhost:3000")
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeServiceImpl;

    @PostMapping("/addEmployee")
    public EmployeeEntity addEmployee(@RequestBody EmployeeEntity employeeEntity) throws IncompleteDetailsProvided {
        if(employeeEntity.getOnBoardingStatus()==null || employeeEntity.getChapterName()==null || employeeEntity.getManagerName()==null
            || employeeEntity.getLocation()==null || employeeEntity.getEmpRole()==null || employeeEntity.getEmailId()==null
            || employeeEntity.getEmpId()==null || employeeEntity.getEmpName()==null || employeeEntity.getNwaCode()==null ||employeeEntity.getPhone()==null){
            throw new IncompleteDetailsProvided("Incomplete inputs are provided");
        }
        System.out.println(employeeEntity);
        return employeeServiceImpl.saveEntity(employeeEntity);
    }

    @GetMapping("/getAllEmployees")
    public List<EmployeeEntity> getEmployees(){
        return employeeServiceImpl.getAll();
    }

    @GetMapping("/checkEmpId")
    public ResponseEntity checkEmpId(@RequestParam String empId) throws IncompleteDetailsProvided {
        if(empId==null){
            throw new IncompleteDetailsProvided("EmpId input is missing");
        }
        return employeeServiceImpl.checkEmpId(empId);
    }
}

