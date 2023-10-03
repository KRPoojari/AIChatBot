package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import com.rest.entity.CompanyDetailsQuestionnaire;
import com.rest.exception.APIFailureException;
import com.rest.exception.IncompleteDetailsProvided;
import com.rest.responseModel.QuestionnaireCompanyResponse;
import com.rest.service.CompanyDetailsQuestionnaireService;

import java.util.List;

@RestController
@EnableAutoConfiguration
@CrossOrigin("http://localhost:3000")
@RequestMapping("company")
public class CompanyDetailsQuestionnaireController {

    @Autowired
    private CompanyDetailsQuestionnaireService companyQuestionnaireService;

    @PostMapping("/addCompanyQuestionnaire")
    public CompanyDetailsQuestionnaire addEmployee(@RequestBody CompanyDetailsQuestionnaire companyDetailsQuestionnaire) throws IncompleteDetailsProvided {
        if(companyDetailsQuestionnaire.getKeyword()==null || companyDetailsQuestionnaire.getQuestion()==null){
            throw new IncompleteDetailsProvided("Incomplete inputs are provided");
        }
        System.out.println(companyDetailsQuestionnaire);
        return companyQuestionnaireService.saveData(companyDetailsQuestionnaire);
    }

    @GetMapping("/getAllDetailsQuestionnaire")
    public List<CompanyDetailsQuestionnaire> getEmployees(){
        return companyQuestionnaireService.getAllData();
    }


    @GetMapping("/getAnswer")
    public QuestionnaireCompanyResponse getAnswerByQuestion(@RequestParam String question) throws IncompleteDetailsProvided, APIFailureException {
        System.out.println(question);
        if(question == null) {
            throw new IncompleteDetailsProvided("Question is empty");
        }
        QuestionnaireCompanyResponse response = companyQuestionnaireService.getAnswerByQuestion(question);
        return response;
    }

}