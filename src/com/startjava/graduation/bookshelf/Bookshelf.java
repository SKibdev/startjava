package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {
    private static final int MAX_QUANTITY_BOOKS = 10;
    private static final Book[] books = new Book[MAX_QUANTITY_BOOKS];
    private int quantityBooks;
    private int shelfLength;

    public int getQuantityBooks() {
        return quantityBooks;
    }

    public int getShelfLength() {
        return shelfLength;
    }

    public int getBookLength() {
        return books.length;
    }

    public int getFreeShelves() {
        return books.length - quantityBooks;
    }

    public Book[] getAllBooks() {
        return Arrays.copyOf(books, quantityBooks);
    }

    public void save(Book book) {
        books[quantityBooks] = (Book) book.clone();
        if (books[quantityBooks].getInfoLength() > shelfLength) {
            shelfLength = books[quantityBooks].getInfoLength();
        }
        quantityBooks++;
    }

    public Book findBook(String title) {
        for (int i = 0; i < quantityBooks; i++) {
            String bookTitle = books[i].getTitle();
            if (bookTitle.contains(title)) {
                return books[i];
            }
        }
        throw new RuntimeException("Книга не найдена!");
    }

    public String deleteBook(String title) {
        int tmpLength = -1;
        String bookTitle = "";
        //Ищем книгу
        for (int i = 0; i < quantityBooks; i++) {
            bookTitle = books[i].getTitle();
            if (bookTitle.contains(title)) {
                //Сохраняем длину удаляемой книги
                tmpLength = books[i].getInfoLength();
                //Удаляем книгу
                if (quantityBooks > 1 &&  i < (books.length - 1)) {
                    System.arraycopy(books, (i + 1), books, i, (quantityBooks - (i + 1)));
                    books[quantityBooks - 1] = null;
                    break;
                } else {
                    books[i] = null;
                }
            }
        }
        if (tmpLength == -1) {
            throw new RuntimeException("Книга не найдена!");
        }
        quantityBooks--;
        //Корректируем длину шкафа
        updateShelfLength(tmpLength);
        return bookTitle;
    }

    private void updateShelfLength(int tmpLength) {
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

    public void clearBookshelf() {
        Arrays.fill(books, 0, quantityBooks, null);
        quantityBooks = 0;
        shelfLength = 0;
    }
}
