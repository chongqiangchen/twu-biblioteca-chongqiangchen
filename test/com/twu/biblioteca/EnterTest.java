package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class EnterTest {

    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;

    private User user = new User();

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private String getOutput() {
        return testOut.toString();
    }

    @Test
    public void theOneWhereWeGetAWelcomeMessage() {
        user.welcomeMessage();
        assertThat(getOutput(), containsString("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!”"));
    }


    @Test
    public void test() {
        assertEquals(1, 1);
    }
}
