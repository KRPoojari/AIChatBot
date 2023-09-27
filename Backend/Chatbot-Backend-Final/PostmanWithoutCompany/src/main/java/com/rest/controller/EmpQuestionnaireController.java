package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rest.entity.EmployeeQuestionnaireEntity;
import com.rest.exception.APIFailureException;
import com.rest.exception.IncompleteDetailsProvided;
import com.rest.responseModel.QuestionnaireCompanyResponse;
import com.rest.responseModel.QuestionnairePersonalResponse;
import com.rest.service.EmpQuestionnaireService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("employee")
public class EmpQuestionnaireController {

    @Autowired
    private EmpQuestionnaireService empQuestionnaireServiceImpl;

    @PostMapping("/addEmpQuestionnaire")
    public EmployeeQuestionnaireEntity addEmpQ(@RequestBody EmployeeQuestionnaireEntity employeeQuestionnaire) throws APIFailureException, IncompleteDetailsProvided {
        System.out.println(employeeQuestionnaire);
        if(employeeQuestionnaire == null) {
            throw new IncompleteDetailsProvided("EmployeeQuestionnaireEntity is not found");
        }
        return empQuestionnaireServiceImpl.create(employeeQuestionnaire);
    }

    @GetMapping("/getAnswers")
    public QuestionnairePersonalResponse getAnswer(@RequestParam(required = true) String question,
                                                   @RequestParam(required = true) String empId) throws APIFailureException, IncompleteDetailsProvided {
        System.out.println(empId);
        if(empId == null){
            throw new IncompleteDetailsProvided("No Employee Id found");
        }
        return empQuestionnaireServiceImpl.getAnswer(question,empId);
    }

}
