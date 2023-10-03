package com.rest.exception;

import com.rest.exception.APIFailureException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class APIFailureExceptionTest {

    @Test
    public void testAPIFailureException() {
       
        String errorMessage = "API failed.";

                APIFailureException exception = assertThrows(APIFailureException.class, () -> {
            throw new APIFailureException(errorMessage);
        });

     
        assertEquals(errorMessage, exception.getMessage());
    }
}
