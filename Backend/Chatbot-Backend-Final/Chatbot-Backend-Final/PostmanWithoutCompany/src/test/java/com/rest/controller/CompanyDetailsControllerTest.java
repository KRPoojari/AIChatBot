package com.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.controller.CompanyDetailsController;
import com.rest.entity.CompanyDetails;
import com.rest.exception.IncompleteDetailsProvided;
import com.rest.service.CompanyDetailsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyDetailsControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Mock
    private CompanyDetailsService companyDetailsService;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

  @Test
    public void testAddCompanyInfo() throws Exception {
        CompanyDetails companyDetails = new CompanyDetails();
        companyDetails.setFile_link("file-link");
        companyDetails.setFile_name("file-name");
        companyDetails.setFile_type("file-type");

        ObjectMapper objectMapper = new ObjectMapper();
        String companyDetailsJson = objectMapper.writeValueAsString(companyDetails);

        Mockito.when(companyDetailsService.saveData(Mockito.any(CompanyDetails.class))).thenReturn(companyDetails);

        mockMvc.perform(post("/company/addCompanyInfo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(companyDetailsJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.file_link").value("file-link"))
                .andExpect(jsonPath("$.file_name").value("file-name"))
                .andExpect(jsonPath("$.file_type").value("file-type"));
    }

 
  
}
