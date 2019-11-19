package com.aincorp.stringbackend.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class StringBackendControllerTest {

    @InjectMocks
    StringBackendController stringBackendController;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void reverse() {
        String example = "hello world";
        String result = stringBackendController.reverse(example);
        assertEquals(result ,"dlrow olleh");
    }

    @Test
    public void palindrome() {
        String example = "sadadas";
        Boolean result = stringBackendController.palindrome(example);
        assertEquals(result, true);
    }

    @Test
    public void substring() {

    }
}
