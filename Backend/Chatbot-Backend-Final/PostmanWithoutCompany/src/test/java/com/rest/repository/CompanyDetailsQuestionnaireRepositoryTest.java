package com.rest.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.rest.entity.CompanyDetailsQuestionnaire;
import com.rest.service.CompanyDetailsQuestionnaireService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



public class CompanyDetailsQuestionnaireRepositoryTest {

    @Mock
    private CompanyDetailsQuestionnaireRepository companyDetailsQuestionnaireRepository;

    @InjectMocks
    private CompanyDetailsQuestionnaireService companyDetailsQuestionnaireService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSearchByQuestion() {
        String question = "Sample question";
        CompanyDetailsQuestionnaire sampleCompanyDetailsQuestionnaire = new CompanyDetailsQuestionnaire();
        sampleCompanyDetailsQuestionnaire.setQuestion(question);
        when(companyDetailsQuestionnaireRepository.searchByQuestion(question)).thenReturn(sampleCompanyDetailsQuestionnaire);
        CompanyDetailsQuestionnaire retrievedCompanyDetailsQuestionnaire = companyDetailsQuestionnaireRepository.searchByQuestion(question);
        verify(companyDetailsQuestionnaireRepository, times(1)).searchByQuestion(question);
        assertEquals(sampleCompanyDetailsQuestionnaire, retrievedCompanyDetailsQuestionnaire);
    }

    @Test
    public void testSearchByRootWord() {
        String question = "Sample question";
        String sampleKeyword = "SampleKeyword";
        when(companyDetailsQuestionnaireRepository.searchByRootWord(question)).thenReturn(sampleKeyword);
        String retrievedKeyword = companyDetailsQuestionnaireRepository.searchByRootWord(question);
        verify(companyDetailsQuestionnaireRepository, times(1)).searchByRootWord(question);
        assertEquals(sampleKeyword, retrievedKeyword);
    }
}
