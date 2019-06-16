package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<String> menus;
    private ArrayList<Book> books;

    private Scanner scanner = new Scanner(System.in);

    public Library(ArrayList<Book> books,ArrayList<String> menus){
        this.books = books;
        this.menus = menus;
    }

    public void start(){
        displayMenu();
    }

    public void displayMenu(){
        int index = 0;
        String input;
        for (String menuItem:this.menus){
            index++;
            System.out.println(index + ". " + menuItem);
        }
        input = scanner.next();
        handleMenu(input);
        displayMenu();
    }

    public void handleMenu(String input){
        if ("1".equals(input)) {
            displayAllBooks();
        } else if ("q".equals(input)) {
            System.out.println("Goodbye!");
            System.exit(0);
        } else {
            System.out.println("Please select a valid option!");
        }
    }


    public void displayAllBooks(){
        int index = 0;
        for(Book book:this.books){
            index++;
            System.out.println(index+"、 "+ book.getBookInfo());
        }
    }
}
