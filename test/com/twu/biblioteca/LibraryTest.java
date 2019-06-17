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
    private User user1;

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

        ArrayList<String> menus = new ArrayList<String>();
        menus.add("List of books");

        ArrayList<Book> books = new ArrayList<Book>();
        Book book1 = new Book("JAVA","Tom","2019","001");
        Book book2 = new Book("C++","Bob","2018","002");
        Book book3 = new Book("C++","Bob","2018","003");
        Book book4 = new Book("C++","Bob","2018","004");

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        ArrayList<Movie> movies = new ArrayList<Movie>();
        Movie movie1 = new Movie("movie1","2018","ccq","1","001");
        Movie movie2 = new Movie("movie2","2019","ccq","2","002");
        movies.add(movie1);
        movies.add(movie2);

        ArrayList<User> users = new ArrayList<User>();
        user1 = new User("000-1111","12345","ccc","17855805070");
        users.add(user1);

        Enter enter = new Enter(users);

        library = new Library(menus,books,movies,enter);

        library.checkOutBook("002",user1);
        library.checkOutBook("003",user1);
        library.checkOutMovie("002",user1);
    }

    @Test
    public void theOneWhereWeGetAWelcomeMessage() {
        library.welcomeMessage();
        assertThat(getOutput(), containsString("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!”"));
    }

    @Test
    public void theOneSelectListOfBook(){
        library.handleMenu("1");
        assertThat(getOutput(),containsString("JAVA"));
    }


    @Test
    public void theOneSelectCheckOutBookIsSuccess(){
        library.checkOutBook("001",user1);
        assertThat(getOutput(),containsString("Thank you! Enjoy the book!"));
    }

    @Test
    public void theOneSelectCheckOutBookIsFail(){
        library.checkOutBook("002",user1);
        assertThat(getOutput(),containsString("Sorry, that book is not available."));
    }

    @Test
    public void theOneSelectReturnBackBookIsSuccess(){
        library.returnBackBook("003");
        assertThat(getOutput(),containsString("Thank you for returning the book"));
    }

    @Test
    public void theOneSelectReturnBackBookIsFail(){
        library.returnBackBook("004");
        assertThat(getOutput(),containsString("That is not a valid book to return."));
    }

    @Test
    public void theOneSelectListOfMovie(){
        library.displayAllMovies();
        assertThat(getOutput(),containsString("movie1"));
    }

    @Test
    public void theOneSelectCheckOutMovieIsSuccess(){
        library.checkOutMovie("001",user1);
        assertThat(getOutput(),containsString("Thank you! Enjoy the movie!"));
    }

    @Test
    public void theOneSelectCheckOutMovieIsFail(){
        library.checkOutMovie("002",user1);
        assertThat(getOutput(),containsString("Sorry, that movie is not available."));
    }

}
