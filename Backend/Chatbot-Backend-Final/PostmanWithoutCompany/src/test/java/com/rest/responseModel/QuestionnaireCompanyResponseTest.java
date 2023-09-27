package com.rest.responseModel;

import com.rest.responseModel.QuestionnaireCompanyResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class QuestionnaireCompanyResponseTest {

    @Test
    public void testGetSetAnswer() {
       
        QuestionnaireCompanyResponse response = new QuestionnaireCompanyResponse();

        
        response.setAnswer("Sample Answer");

        
        assertEquals("Sample Answer", response.getAnswer());
    }

    @Test
    public void testGetSetDescription() {
 
        QuestionnaireCompanyResponse response = new QuestionnaireCompanyResponse();

        
        response.setDescription("Sample Description");

        
        assertEquals("Sample Description", response.getDescription());
    }
    
    @Test
    public void testDefaultConstructor() {
        
        QuestionnaireCompanyResponse response = new QuestionnaireCompanyResponse();

        assertNull(response.getAnswer());
        assertNull(response.getDescription());
    }
}
