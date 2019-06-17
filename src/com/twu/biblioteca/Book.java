package com.twu.biblioteca;

public class Book extends LibraryItem {
    private String title;
    private String author;
    private String year;

    public Book(String title,String author,String year,String Id){
        super(Id);
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getBookInfo(){
        String formatBookInfo =title + ", " + author +", " + year + ", " + getId();
        return formatBookInfo;
    }
}
