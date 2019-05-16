package com.example.android.ramanlibrary;

/**
 * Created by SanjanaRaman on 7/8/18.
 */


public class Book {
    private String title;
    private String author;
    private Genre genre;
    private String ID;


    public Book() {}
    public Book(String title, String author, Genre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return this.genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getID() {return this.ID;}
}
