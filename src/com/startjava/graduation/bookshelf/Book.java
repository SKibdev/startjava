package com.startjava.graduation.bookshelf;

public class Book {
    private String author;
    private String title;
    private int year;
    private int infoLength;


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
            this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
            this.title = title;
    }

    public int getYear() {
        return year;
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
/*
|Ирвинг Стоун, Жажда жизни, 1973             |
--------------------------------------------|
|Рэй Брэдбери, 451 градус по Фаренгейту, 1980|
|--------------------------------------------|
|                                            |
 */
