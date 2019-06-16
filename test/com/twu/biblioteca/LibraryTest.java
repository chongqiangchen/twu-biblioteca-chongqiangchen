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
        Book book1 = new Book("JAVA","Tom","2019","001");
        Book book2 = new Book("C++","Bob","2018","002");
        books.add(book1);
        books.add(book2);
        ArrayList<String> menus = new ArrayList<String>();
        menus.add("List of books");

        library = new Library(books,menus);

        library.checkOutBook("002");
    }

//    @Test
//    public void theOneWhereTheMenusAreShowed(){
//        library.displayMenu();
//        assertThat(getOutput(),containsString("List of books"));
//    }

    @Test
    public void theOneSelectListOfBook(){
        library.handleMenu("1");
        assertThat(getOutput(),containsString("JAVA"));
    }


    @Test
    public void theOneSelectCheckOutBookIsSuccess(){
//        library.handleMenu("2");
        library.checkOutBook("001");
        assertThat(getOutput(),containsString("Thank you! Enjoy the book!"));
    }

    @Test
    public void theOneSelectCheckOutBookIsFail(){
//        library.handleMenu("3");
        library.checkOutBook("002");
        assertThat(getOutput(),containsString("Sorry, that book is not available."));
    }

    @Test
    public void theOneWhereAllBooksAreShowed(){
        library.displayAllBooks();
        assertThat(getOutput(), containsString("JAVA"));
    }


}
