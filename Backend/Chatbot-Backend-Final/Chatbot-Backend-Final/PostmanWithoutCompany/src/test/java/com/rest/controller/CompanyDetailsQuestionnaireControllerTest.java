package com.rest.controller;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CompanyDetailsQuestionnaireControllerTest {

    @Autowired
    private MockMvc mockMvc;



    @Test
    public void getAllDetails() throws Exception {
        mockMvc.perform(get("http://localhost:8080/company/getAllDetailsQuestionnaire")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }



}