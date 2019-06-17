package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LoginTest {

    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;

    private Enter enter;
    private ArrayList<User> users = new ArrayList<User>();

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }
    @Before
    public void initialData(){
        User user1 = new User("000-1111","12345","chongqiangchen@gmail.com","17855805070");
        users.add(user1);

        enter = new Enter(users);
    }

    private String getOutput() {
        return testOut.toString();
    }


    @Test
    public void test() {
        assertEquals(1, 1);
    }
}
