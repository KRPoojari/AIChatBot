package com.rest.responseModel;

import com.rest.responseModel.QuestionnairePersonalResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class QuestionnairePersonalResponseTest {

    @Test
    public void testGetSetAnswer() {
        
        QuestionnairePersonalResponse response = new QuestionnairePersonalResponse();

       
        response.setAnswer("Sample Answer");

      
        assertEquals("Sample Answer", response.getAnswer());
    }
    
    @Test
    public void testDefaultConstructor() {
        
        QuestionnairePersonalResponse response = new QuestionnairePersonalResponse();


        assertNull(response.getAnswer());
    }
}
