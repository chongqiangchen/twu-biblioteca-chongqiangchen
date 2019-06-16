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
        input = setString();
        handleMenu(input);
        displayMenu();
    }

    public void handleMenu(String input){
        if ("1".equals(input)) {
            displayAllBooks();
        }else if("2".equals(input)){
            checkOutBook(setString());
        }else if("3".equals(input)){
            returnBackBook(setString());
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
    public boolean checkOutBook(String bookId){
        for (Book book:this.books){
            if(book.getId().equals(bookId) && book.isAvailable()){
                book.checkOut();
                System.out.println("Thank you! Enjoy the book!");
                return true;
            }
        }
        System.out.println("Sorry, that book is not available.");
        return false;
    }

    public boolean returnBackBook(String bookId){
        for (Book book:this.books){
            if(book.getId().equals(bookId) && !book.isAvailable()){
                book.returnBack();
                System.out.println("Thank you for returning the book.");
                return true;
            }
        }

        System.out.println("That is not a valid book to return.");
        return false;
    }

    private String setString(){
        String input = scanner.next();
        return input;
    }
}
