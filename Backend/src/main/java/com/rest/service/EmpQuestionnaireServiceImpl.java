package com.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.porterStemmer;
import com.rest.stopWordsRemoval;
import com.rest.entity.EmployeeEntity;
import com.rest.entity.EmployeeQuestionnaireEntity;
import com.rest.exception.APIFailureException;
import com.rest.repository.EmpQuestionnaireRepository;
import com.rest.repository.EmployeeRepository;
import com.rest.responseModel.QuestionnairePersonalResponse;
//import com.sun.tools.javac.util.Log;

import java.util.*;

@Service
public class EmpQuestionnaireServiceImpl implements EmpQuestionnaireService {

    @Autowired
    private EmpQuestionnaireRepository questionnaireRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeQuestionnaireEntity create(EmployeeQuestionnaireEntity questionnaireEntity) throws APIFailureException {
        return questionnaireRepository.save(questionnaireEntity);
    }

    @Override
    public QuestionnairePersonalResponse getAnswer(String question, String empId) throws APIFailureException {
        QuestionnairePersonalResponse questionnairePersonalResponse = new QuestionnairePersonalResponse();

        System.out.println(empId);
        
        EmployeeEntity employeeEntity = employeeRepository.searchByEmpId(empId);
        System.out.println(employeeEntity);
        if (employeeEntity == null) {
            questionnairePersonalResponse.setAnswer("Please enter the correct Employee Id");
            return questionnairePersonalResponse;
        }

       String res = questionToAnswer(question, employeeEntity);
        questionnairePersonalResponse.setAnswer(res);
        return questionnairePersonalResponse;
    }
  /*  public String getManagerName(String empId) {
        EmployeeEntity employee = employeeRepository.searchByEmpId(empId);
        if (employee != null) {
            return "Your manager is " + employee.getManagerName();
        } else {
            return "Employee not found. Please check the Employee Id.";
        }
    }*/



    private String questionToAnswer(String question, EmployeeEntity employeeEntity){
        String[] words = question.toLowerCase().split(" ");
        stopWordsRemoval stpRemove = new stopWordsRemoval();
        HashSet<String> cleanedWords = stpRemove.removeStopWord(words);
        porterStemmer obj = new porterStemmer();
        String kw = "";
        List<String> rwList = new ArrayList<>(),uList = new ArrayList<>();
        String res = "";
        int count=0;
        System.out.println("Question: " + question);
        boolean keywordFound = false;
        for (String str : cleanedWords) {
            System.out.println(str + "- > " + obj.stemWord(str));
            rwList.add(obj.stemWord(str));
             kw = questionnaireRepository.findKeywordByQuestion(question);
            //kw = questionnaireRepository.searchByRootWord(obj.stemWord(str));
           // kw = questionnaireRepository.searchByRootWord(obj.stemWord(str).toLowerCase());
            System.out.println("Keyword is :" + kw);
           // int count=0;
           if (kw == null ) {
                count+=1;
                if(count == cleanedWords.size()){
                    //questionnairePersonalResponse.setAnswer("Keyword not found in the entered question");
                    res+="Please re-check the entered question";
                }
                count+=1;
                //throw new APIFailureException("Keyword not found in the entered question");
                continue;
            }
           else {
        	   count = 0;
               keywordFound = true;

            if ( uList.contains(kw)) {
                continue;
            }
          
            uList.add(kw);
            switch (kw) {
                case "manager":
                    res += "Your Manager name is " + employeeEntity.getManagerName() + " ";
                    break;
                case "chapter_name":
                    res += "Your Chapter name is " + employeeEntity.getChapterName() + " ";
                    break;
                case "nwa_code":
                    res += "Use this NWA Code in your time sheets: " + employeeEntity.getNwaCode() + " ";
                    break;
                case "location":
                    res += "You are currently located in " + employeeEntity.getLocation() + " office";
                    break;
                case "role":
                    res += "Your role / designation in telstra is " + employeeEntity.getEmpRole();
                    break;
                case "onboardingstatus":
                    res += "Your On-boarding status in Telstra is " + employeeEntity.getOnBoardingStatus();
                    break;
                case "default":
            }
        }
        }
        System.out.println("res"+res);
        if(res.isEmpty()){
            res+=" The answer for the required message is not found";
        }
        return res;
    }
}
