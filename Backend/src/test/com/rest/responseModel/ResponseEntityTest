package com.rest.responseModel;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import com.rest.responseModel.ResponseEntity;

public class ResponseEntityTest {

    private ResponseEntity responseEntity;

    @Before
    public void setUp() {
        responseEntity = new ResponseEntity();
    }

    @Test
    public void testGetResult() {
        responseEntity.setResult("Success");
        assertEquals("Success", responseEntity.getResult());
    }

    @Test
    public void testGetMessage() {
        responseEntity.setMessage("Operation completed successfully");
        assertEquals("Operation completed successfully", responseEntity.getMessage());
    }

    @Test
    public void testSetResult() {
        responseEntity.setResult("Failure");
        assertEquals("Failure", responseEntity.getResult());
    }

    @Test
    public void testSetMessage() {
        responseEntity.setMessage("An error occurred");
        assertEquals("An error occurred", responseEntity.getMessage());
    }
}
