package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<String> menus;
    private ArrayList<Book> books;
    private ArrayList<Movie> movies;

    private Scanner scanner = new Scanner(System.in);
    private Enter enter;

    public Library(ArrayList<String> menus,ArrayList<Book> books,ArrayList<Movie> movies,Enter enter){
        this.menus = menus;
        this.books = books;
        this.movies = movies;
        this.enter = enter;

    }

    public void start(){
        displayMenu();
    }
    public void welcomeMessage(){
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!”");
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
            if(enter.isLogin()){
                checkOutBook(setString(),enter.getCurUser());
            }else {
                System.out.println("You should login before check out the book!");
                enter.login();
            }
        }else if("4".equals(input)){
            checkOutMovie(setString(),enter.getCurUser());
        }else if("5".equals(input)){
            if(enter.isLogin()){
                returnBackBook(setString());
            }else {
                System.out.println("You should login before return back the book!");
                enter.login();
            }
        }else if("6".equals(input)){
            returnBackMovie(setString());
        } else if ("7".equals(input)) {
            if(enter.isLogin()){
               System.out.println( enter.getUserInfo());
            }else {
                System.out.println("You should login before show your info!");
                enter.login();
            }
        }  else if ("8".equals(input)) {
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
    public boolean checkOutBook(String bookId,User curUser){
        for (Book book:this.books){
            if(book.getId().equals(bookId) && book.isAvailable()){
                book.checkOut(curUser);
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

    public boolean checkOutMovie(String movieId,User curUser){
        for (Movie movie:this.movies){
            if(movie.getId().equals(movieId) && movie.isAvailable()){
                movie.checkOut(curUser);
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
