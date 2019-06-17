package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        User user = new User();

        ArrayList<Book> books = new ArrayList<Book>();
        Book book1 = new Book("Java","Tom","2019","001");
        Book book2 = new Book("C++","Bob","2018","002");
        books.add(book1);
        books.add(book2);

        ArrayList<Movie> movies = new ArrayList<Movie>();
        Movie movie1 = new Movie("movie1","2019","ccq","1","001");
        Movie movie2 = new Movie("movie2","2018","ccq","2","002");
        movies.add(movie1);
        movies.add(movie2);

        ArrayList<String> menus = new ArrayList<String>();
        menus.add("-------- Welcome -------");
        menus.add("1、List of books");
        menus.add("2、List of movies");
        menus.add("3、Check out a book");
        menus.add("4、Check out a movie");
        menus.add("5、Return back a book");
        menus.add("6、Return back a movie");
        menus.add("7、Exit");
        menus.add("------------------------");

        Library library = new Library(menus,books,movies);

        user.welcomeMessage();
        library.start();
    }
}
