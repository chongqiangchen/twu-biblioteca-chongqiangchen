package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        User user = new User();

        ArrayList<Book> books = new ArrayList<Book>();
        Book book1 = new Book("Java","Tom","2019");
        Book book2 = new Book("C++","Bob","2018");
        books.add(book1);
        books.add(book2);

        ArrayList<String> menus = new ArrayList<String>();
        menus.add("List of books");

        Library library = new Library(books,menus);

        user.welcomeMessage();
        library.start();
//        library.displayAllBooks();
    }
}
