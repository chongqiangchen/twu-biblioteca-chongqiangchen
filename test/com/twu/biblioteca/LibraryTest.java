package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LibraryTest {

    private Library library;

    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private String getOutput() {
        System.out.println(testOut.toString());
        return testOut.toString();
    }

    @Before
    public void initialData(){
        ArrayList<Book> books = new ArrayList<Book>();
        Book book1 = new Book("JAVA","Tom","2019");
        Book book2 = new Book("C++","Bob","2018");
        books.add(book1);
        books.add(book2);
        ArrayList<String> menus = new ArrayList<String>();
        menus.add("List of books");

        library = new Library(books,menus);
    }

    @Test
    public void theOneWhereTheMenusAreShowed(){
        library.displayMenu();
        assertThat(getOutput(),containsString("List of books"));
    }

    @Test
    public void theOneSelectAMenuItem(){
        library.handleMenu("1");
        assertThat(getOutput(),containsString("JAVA"));
    }

    @Test
    public void theOneWhereAllBooksAreShowed(){
        library.displayAllBooks();
        assertThat(getOutput(), containsString("JAVA"));
    }


}
