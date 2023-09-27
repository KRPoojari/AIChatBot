package com.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.controller.EmployeeController;
import com.rest.entity.EmployeeEntity;
import com.rest.exception.IncompleteDetailsProvided;
import com.rest.responseModel.ResponseEntity;
import com.rest.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class EmployeeControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

   /* @Test
    public void testAddEmployee() throws Exception {
        // Prepare a sample EmployeeEntity object
        EmployeeEntity employee = new EmployeeEntity();
        employee.setEmpId("EMP001");
        employee.setEmpName("Alex");
        // Set other required fields as needed

        // Prepare the expected response
        when(employeeService.saveEntity(any())).thenReturn(employee);

        // Perform the POST request with JSON content
        mockMvc.perform(post("/employee/addEmployee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employee)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.empId").value("EMP001"))
                .andExpect(jsonPath("$.empName").value("Alex"));
    }*/

   

    @Test
    public void testGetAllEmployees() throws Exception {
       
        List<EmployeeEntity> employees = new ArrayList<>();
        

        
        when(employeeService.getAll()).thenReturn(employees);

       
        mockMvc.perform(get("/employee/getAllEmployees"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
               
    }

    @Test
    public void testCheckEmpId() throws Exception {
      
        String empId = "123";

        
        ResponseEntity response = new ResponseEntity();
        response.setMessage("Employee exists");

      
        when(employeeService.checkEmpId(empId)).thenReturn(response);

       
        mockMvc.perform(get("/employee/checkEmpId")
                .param("empId", empId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Employee exists"));
    }

    @Test
    public void testCheckEmpIdWithMissingParameter() throws Exception {
        
        mockMvc.perform(get("/employee/checkEmpId"))
                .andExpect(status().isBadRequest());
    }

    
    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

