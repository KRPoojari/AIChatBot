package com.rest.service;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import com.rest.entity.CompanyDetails;
import com.rest.entity.CompanyDetailsQuestionnaire;
import com.rest.exception.APIFailureException;
import com.rest.repository.CompanyDetailsQuestionnaireRepository;
import com.rest.repository.CompanyDetailsRepository;
import com.rest.responseModel.QuestionnaireCompanyResponse;

public class CompanyDetailsQuestionnaireServiceTest {

    @Mock
    private CompanyDetailsQuestionnaireRepository companyQuestionnaireRepository;

    @Mock
    private CompanyDetailsRepository companyDetailsRepository;

    @InjectMocks
    private CompanyDetailsQuestionnaireService companyDetailsQuestionnaireService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveData() {
        CompanyDetailsQuestionnaire questionnaire = new CompanyDetailsQuestionnaire();
        when(companyQuestionnaireRepository.save(questionnaire)).thenReturn(questionnaire);

        CompanyDetailsQuestionnaire savedQuestionnaire = companyDetailsQuestionnaireService.saveData(questionnaire);
        assertEquals(questionnaire, savedQuestionnaire);
    }

    @Test
    public void testGetAllData() {
        List<CompanyDetailsQuestionnaire> questionnaireList = new ArrayList<>();
        when(companyQuestionnaireRepository.findAll()).thenReturn(questionnaireList);

        List<CompanyDetailsQuestionnaire> retrievedList = companyDetailsQuestionnaireService.getAllData();
        assertEquals(questionnaireList, retrievedList);
    }

    @Test
    public void testDeleteById() {
        Integer id = 1;
        companyDetailsQuestionnaireService.deleteById(id);
        verify(companyQuestionnaireRepository, times(1)).deleteById(id);
    }

    @Test
    public void testGetAnswerByQuestion() throws APIFailureException {
        String question = "What is the Code of Conduct?";
        CompanyDetails companyDetails = new CompanyDetails();
        companyDetails.setFile_link("Code_Of_Conduct_Link");
        when(companyQuestionnaireRepository.searchByRootWord(anyString())).thenReturn("Code_Of_Conduct");
        when(companyDetailsRepository.searchByFileName("Code_Of_Conduct")).thenReturn(companyDetails);

        QuestionnaireCompanyResponse response = companyDetailsQuestionnaireService.getAnswerByQuestion(question);

      
        assertEquals("Code_Of_Conduct_Link", response.getAnswer().trim());
        assertEquals("Code Of Conduct", response.getDescription().trim());
    }

   
}
