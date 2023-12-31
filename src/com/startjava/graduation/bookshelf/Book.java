package com.startjava.graduation.bookshelf;

public class Book {
    private final String author;
    private final String title;
    private final int yearPublication;
    private final int infoLength;

    public Book(String author, String title, int yearPublication) {
        this.author = author;
        this.title = title;
        this.yearPublication = yearPublication;
        infoLength = toString().length();
    }

    public String getTitle() {
        return title;
    }

    public int getInfoLength() {
        return infoLength;
    }

    @Override
    public String toString() {
        return author + ", " + title + ", " + yearPublication;
    }

    @Override
    public Object clone() {
        return new Book(author, title, yearPublication);
    }
}

