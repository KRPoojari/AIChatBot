package com.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.controller.EmpQuestionnaireController;
import com.rest.entity.EmployeeQuestionnaireEntity;
import com.rest.responseModel.QuestionnairePersonalResponse;
import com.rest.service.EmpQuestionnaireService;
import com.rest.exception.APIFailureException;
import com.rest.exception.IncompleteDetailsProvided;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmpQuestionnaireControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private EmpQuestionnaireController empQuestionnaireController;

    @Mock
    private EmpQuestionnaireService empQuestionnaireService;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testAddEmpQ() throws Exception {
       
        EmployeeQuestionnaireEntity employeeQuestionnaire = new EmployeeQuestionnaireEntity();
   
        when(empQuestionnaireService.create(any(EmployeeQuestionnaireEntity.class))).thenReturn(employeeQuestionnaire);

        mockMvc.perform(MockMvcRequestBuilders.post("/employee/addEmpQuestionnaire")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employeeQuestionnaire)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAnswer() throws Exception {
     
        String question = "Sample Question";
        String empId = "123";

        
        QuestionnairePersonalResponse response = new QuestionnairePersonalResponse();
        

        when(empQuestionnaireService.getAnswer(question, empId)).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/employee/getAnswers")
                .param("question", question)
                .param("empId", empId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    

}
