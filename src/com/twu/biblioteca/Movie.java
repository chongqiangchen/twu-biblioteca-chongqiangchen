package com.twu.biblioteca;

public class Movie extends LibraryItem {
    private String name;
    private String year;
    private String director;
    private String rating;

    public Movie(String name, String year, String director, String rating, String Id) {
        super(Id);
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getMovieInfo(){
        String formatMovieInfo = this.name + ", " + this.year + ", " + this.director + ", " + this.rating;
        return formatMovieInfo;
    }

}
