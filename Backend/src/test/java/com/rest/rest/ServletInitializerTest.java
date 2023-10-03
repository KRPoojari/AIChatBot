package com.rest.rest;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.rest.ServletInitializer;

@SpringBootTest
public class ServletInitializerTest {

    @Test
    public void testConfigure() {
        ServletInitializer initializer = new ServletInitializer();
        // You can add more specific test cases for the ServletInitializer if needed.
    }
}