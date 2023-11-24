package com.startjava.graduation.bookshelf;

public class Book {
    private String author;
    private String title;
    private int year;
    private int informationLength;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author.length() <= 15) {
            this.author = author;
        } else {
            this.author = author.substring(0,15);
        }
        informationLength += this.author.length();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.length() <= 21) {
            this.title = title;
        } else {
            this.title = title.substring(0,21);
        }
        informationLength += this.title.length();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 0 && year <= 2023) {
            this.year = year;
        } else {
            this.year = 0;
        }
        informationLength += String.valueOf(this.year).length();
    }

    public void setInformationLength(int informationLength) {
        this.informationLength = informationLength;
    }

    @Override
    public String toString() {
        // Добавляем недостающие пробелы для выравнивания полки
        // Количесвто пробелов = длина шкафа 44 символа - длина информации о книге + 4 длина разделитейлей ", "
        int quantitySpace = 44 - (informationLength + 4);
        String spaceStr = "";
             for (int i = 1; i <= quantitySpace; i++) {
                spaceStr += " ";
            }

        return "|" + author + ", " + title + ", " + year + spaceStr +
                "|\n|--------------------------------------------|\n";
    }
}
/*
|Ирвинг Стоун, Жажда жизни, 1973             |
--------------------------------------------|
|Рэй Брэдбери, 451 градус по Фаренгейту, 1980|
|--------------------------------------------|
|                                            |
 */
