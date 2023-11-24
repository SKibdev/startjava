package com.startjava.graduation.bookshelf;

public class Bookshelf {
    private static int quantityBooks = 0;

    private final static Book[] books = new Book[10];

    public static int getQuantityBooks() {
        return quantityBooks;
    }

    public static void addBook(String author, String title, int year) {
            books[quantityBooks] = new Book();
            books[quantityBooks].setAuthor(author);
            books[quantityBooks].setTitle(title);
            books[quantityBooks++].setYear(year);
    }

    public static Book getBook(int index) {
        return books[index];
    }

    public static String getAllBooks() {
        String str = "";
        for (int i = 0; i < quantityBooks; i++) {
            str += books[i].toString();
        }
        return str;
    }

    public static int getFreeShelves() {
        return 10 - quantityBooks;
    }

    public static int findBook(String searchQuery) {
        for (int i = 0; i < quantityBooks; i++) {
            String str = books[i].getTitle();
            int result = str.indexOf(searchQuery);
            if (result > -1) {
                return i;
            }
        }
        return -1;
    }

    public static void deleteBook(int indexDel) {
        System.arraycopy(books, indexDel++, books, indexDel - 1, (quantityBooks - indexDel));
        books[quantityBooks--] = null;
    }

    public static void clearBookshelf() {
        for (int i = 0; i < quantityBooks; i++) {
            books[i] = null;
        }
        quantityBooks = 0;
    }
    /*
    TO DO
    Посмотреть содержимое шкафа
    Bookshelf.get all books + Bookshelf.getQuantityFreeShelves

    Добавить книгу Bookshelf.addBook();
    Найти книгу Bookshelf.searchBook();
    Удалить книгу Bookshelf.deleteBook();
    Очистить шкаф Bookshelf.clearBookshelf();

add a book
find for a book
delete a book
get all books (only for cabinet visualization)

get the number of free shelves получить количество свободных полок
clear Bookshelf
     */
}
