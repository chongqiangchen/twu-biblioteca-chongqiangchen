package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<String> menus;
    private ArrayList<Book> books;
    private ArrayList<Movie> movies;

    private Scanner scanner = new Scanner(System.in);

    public Library(ArrayList<String> menus,ArrayList<Book> books,ArrayList<Movie> movies){
        this.menus = menus;
        this.books = books;
        this.movies = movies;
    }

    public void start(){
        displayMenu();
    }

    public void displayMenu(){
        String input;
        for (String menuItem:this.menus){
            System.out.println(menuItem);
        }
        input = setString();
        handleMenu(input);
        displayMenu();
    }

    public void handleMenu(String input){
        if ("1".equals(input)) {
            displayAllBooks();
        }else if("2".equals(input)){
            displayAllMovies();
        }else if("3".equals(input)){
            checkOutBook(setString());
        }else if("4".equals(input)){
            checkOutMovie(setString());
        }else if("5".equals(input)){
            returnBackBook(setString());
        }else if("6".equals(input)){
            returnBackMovie(setString());
        } else if ("7".equals(input)) {
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

    public void displayAllMovies() {
        int index = 0;
        for (Movie movie:this.movies){
            index++;
            System.out.println(index + "、 "+movie.getMovieInfo());
        }
    }

    public boolean checkOutMovie(String movieId){
        for (Movie movie:this.movies){
            if(movie.getId().equals(movieId) && movie.isAvailable()){
                movie.checkOut();
                System.out.println("Thank you! Enjoy the movie!");
                return true;
            }
        }
        System.out.println("Sorry, that movie is not available.");
        return false;
    }

    public boolean returnBackMovie(String movieId){
        return true;
    }

    private String setString(){
        String input = scanner.next();
        return input;
    }
}
