package com.rest.service;

import com.rest.entity.EmployeeQuestionnaireEntity;
import com.rest.exception.APIFailureException;
import com.rest.responseModel.QuestionnaireCompanyResponse;
import com.rest.responseModel.QuestionnairePersonalResponse;

public interface EmpQuestionnaireService {
    public EmployeeQuestionnaireEntity create(EmployeeQuestionnaireEntity questionnaireEntity) throws APIFailureException;
        public QuestionnairePersonalResponse getAnswer(String question, String empId) throws APIFailureException;
}
