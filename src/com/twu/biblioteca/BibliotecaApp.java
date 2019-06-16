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

        ArrayList<String> menus = new ArrayList<String>();
        menus.add("List of books");
        menus.add("Check out a book");
        menus.add("Return back a book");

        Library library = new Library(books,menus);

        user.welcomeMessage();
        library.start();
    }
}
