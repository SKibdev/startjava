package com.startjava.graduation.bookshelf;

public class Bookshelf {
    private static int quantityBooks;
    private final static Book[] books = new Book[10];
    private static int shelfLength;

    public static int getQuantityBooks() {
        return quantityBooks;
    }

    public static void setShelfLength(int infoLength) {
        if (infoLength > shelfLength) {
            shelfLength = infoLength;
        }
    }

    public static int getShelfLength() {
        return shelfLength;
    }

    public static void addBook(String author, String title, int year) {
        books[quantityBooks] = new Book();
        books[quantityBooks].setAuthor(author);
        books[quantityBooks].setTitle(title);
        books[quantityBooks].setYear(year);
        // 4 - это длина разделителей "' "
        int infoLength = author.length() + title.length() + String.valueOf(year).length() + 4;
        books[quantityBooks++].setInfoLength(infoLength);
        setShelfLength(infoLength);
        System.out.println("Книга добавлена успешно!");
    }

    public static Book getBook(int index) {
        return books[index];
    }

    public static Book[] getAllBooks() {
        Book[] allBooks = new Book[quantityBooks];
        System.arraycopy(books, 0, allBooks, 0, quantityBooks);
        return allBooks;
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
        System.out.println("Книга успешно удалена!");
    }

    public static void clearBookshelf() {
        for (int i = 0; i < quantityBooks; i++) {
            books[i] = null;
        }
        quantityBooks = 0;
        System.out.println("Шкаф пуст");
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
