package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {
    private static final  int MAX_QUANTITY_BOOKS = 10;
    private static final Book[] books = new Book[MAX_QUANTITY_BOOKS];
    private static int quantityBooks;
    private static int shelfLength;

    public static int getQuantityBooks() {
        return quantityBooks;
    }

    public static int getShelfLength() {
        return shelfLength;
    }

    public static Book getBook(int index) {
        return (Book) books[index].clone();
    }

    public static void setBook(Book book) {
        books[quantityBooks++] = (Book) book.clone();
        determineShelfLength(book.getInfoLength());
    }

    private static void determineShelfLength(int infoLength) {
        if (infoLength > shelfLength) {
            shelfLength = infoLength;
        }
    }

    public static int find(String title) {
        for (int i = 0; i < quantityBooks; i++) {
            String str = books[i].getTitle();
            int result = str.indexOf(title);
            if (result > -1) {
                return i;
            }
        }
        throw new RuntimeException("Книга не найдена!");
    }

    public static void delete(int indexDel) {
        int tmpLength = books[indexDel].getInfoLength();
        //Удаляем книгу
        if (quantityBooks > 1 && indexDel < (books.length - 1)) {
            System.arraycopy(books, (indexDel + 1), books, indexDel, (quantityBooks - (indexDel + 1)));
            books[quantityBooks - 1] = null;
        } else {
            books[indexDel] = null;
        }
        quantityBooks--;
        //Корректируем длину шкафа
        if (quantityBooks > 0) {
            if (tmpLength == shelfLength) {
                shelfLength = books[0].getInfoLength();
                for (int i = 1; i < quantityBooks; i++) {
                    shelfLength = Math.max(shelfLength, books[i].getInfoLength());
                }
            }
        } else {
            shelfLength = 0;
        }
    }

    public static void clearBookshelf() {
        Arrays.fill(books, null);
        quantityBooks = 0;
        shelfLength = 0;
    }

    public static int getBookLength() {
        return books.length;
    }

    public static int getFreeShelves() {
        return books.length - quantityBooks;
    }

    public static Book[] getAllBooks() {
        return Arrays.copyOf(books, quantityBooks);
    }
}
