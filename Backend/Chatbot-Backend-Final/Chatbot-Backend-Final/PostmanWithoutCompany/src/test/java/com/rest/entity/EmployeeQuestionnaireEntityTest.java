/**
 * 
 */
package com.rest.entity;

import com.rest.entity.EmployeeQuestionnaireEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeQuestionnaireEntityTest {

    @Test
    public void testEmployeeQuestionnaireEntityGettersAndSetters() {
        
        EmployeeQuestionnaireEntity entity = new EmployeeQuestionnaireEntity();

        entity.setId(1);
        entity.setQuestion("What is your role?");
        entity.setKeyword("role");

        
        assertEquals(1, entity.getId());
        assertEquals("What is your role?", entity.getQuestion());
        assertEquals("role", entity.getKeyword());
    }

   

 
}
