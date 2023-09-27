package com.rest.exception;

import com.rest.exception.IncompleteDetailsProvided;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IncompleteDetailsProvidedTest {

    @Test
    public void testIncompleteDetailsProvided() {
       
        String errorMessage = "Incomplete details provided.";

       
        IncompleteDetailsProvided exception = assertThrows(IncompleteDetailsProvided.class, () -> {
            throw new IncompleteDetailsProvided(errorMessage);
        });

        
        assertEquals(errorMessage, exception.getMessage());
    }
}
