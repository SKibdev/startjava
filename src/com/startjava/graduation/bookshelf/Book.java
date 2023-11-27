package com.startjava.graduation.bookshelf;

public class Book {
    private String author;
    private String title;
    private int year;
    private int infoLength;

    public void setAuthor(String author) {
            this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
            this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setInfoLength(int infoLength) {
        this.infoLength = infoLength;
    }

    public int getInfoLength() {
        return infoLength;
    }

    @Override
    public String toString() {
        return author + ", " + title + ", " + year;
    }
}

