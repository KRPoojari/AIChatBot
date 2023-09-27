package com.rest.entity;

import com.rest.entity.EmployeeEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeEntityTest {

    @Test
    public void testEmployeeEntityGettersAndSetters() {
        
        EmployeeEntity employee = new EmployeeEntity();

        
        employee.setEmpId("EMP001");
        employee.setEmpName("Alex");
        employee.setEmailId("alex@gmail.com");
        employee.setEmpRole("Intern");
        employee.setManagerName("Ava Volkov");
        employee.setChapterName("Infrco");
        employee.setLocation("Puna");
        employee.setNwaCode("1234");
        employee.setPhone("1234567890");
        employee.setOnBoardingStatus("Pending");

       
        assertEquals("EMP001", employee.getEmpId());
        assertEquals("Alex", employee.getEmpName());
        assertEquals("alex@gmail.com", employee.getEmailId());
        assertEquals("Intern", employee.getEmpRole());
        assertEquals("Ava Volkov", employee.getManagerName());
        assertEquals("Infrco", employee.getChapterName());
        assertEquals("Puna", employee.getLocation());
        assertEquals("1234", employee.getNwaCode());
        assertEquals("1234567890", employee.getPhone());
        assertEquals("Pending", employee.getOnBoardingStatus());
    }

   

   
}
