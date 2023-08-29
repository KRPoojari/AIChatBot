package com.example.postman.controller;

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




    @Test
    void getAnswerByQuestion() throws Exception {
        mockMvc.perform(get("http://localhost:8080/company/getAnswer?question=\"what is the Hr Policy\"")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value(" Hr Policies")).andExpect(jsonPath("$.answer").value(" https://drive.google.com/file/d/19-VyfnaX6KPnltH2D3wZTw_oMKRAgzGd/view?usp=sharing"));
        mockMvc.perform(get("http://localhost:8080/company/getAnswer?question=\"what is the Code of conduct\"")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value(" Code Of Conduct")).andExpect(jsonPath("$.answer").value(" https://docs.google.com/presentation/d/1y9SvNj379ez4gG-MyGqz-Fd323y8X3GR/edit?usp=sharing&ouid=103114177312085914127&rtpof=true&sd=true"));
        mockMvc.perform(get("http://localhost:8080/company/getAnswer?question=\"what is my name\"")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").isEmpty()).andExpect(jsonPath("$.answer").isEmpty());

    }
}