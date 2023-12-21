package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {
    public static final int BOOKS_LIMIT = 10;
    private static final Book[] books = new Book[BOOKS_LIMIT];
    private int quantityBooks;
    private int lengthShelves;

    public int getQuantityBooks() {
        return quantityBooks;
    }

    public int getLengthShelves() {
        return lengthShelves;
    }

    public int getFreeShelves() {
        return BOOKS_LIMIT - quantityBooks;
    }

    public Book[] getAllBooks() {
        return Arrays.copyOf(books, quantityBooks);
    }

    public void save(Book book) {
        books[quantityBooks] = (Book) book.clone();
        if (books[quantityBooks].getInfoLength() > lengthShelves) {
            lengthShelves = books[quantityBooks].getInfoLength();
        }
        quantityBooks++;
    }

    public Book find(String title) {
        for (int i = 0; i < quantityBooks; i++) {
            String checkableTitle = books[i].getTitle();
            if (checkableTitle.equals(title)) {
                return books[i];
            }
        }
        throw new RuntimeException("Книга не найдена!");
    }

    public void delete(String title) {
        int currentLength = -1;
        //Ищем книгу
        for (int i = 0; i < quantityBooks; i++) {
            String checkableTitle = books[i].getTitle();
            if (checkableTitle.equals(title)) {
                //Сохраняем длину удаляемой книги
                currentLength = books[i].getInfoLength();
                //Удаляем книгу
                if (quantityBooks > 1 && i < quantityBooks - 1) {
                    //length определяется как разница между количеством книг в шкафу (quantityBooks) и
                    //порядковым номером удаляемой книги (i + 1)
                    System.arraycopy(books, (i + 1), books, i, quantityBooks - i - 1);
                }
                quantityBooks--;
                books[quantityBooks] = null;
                break;
            }
        }
        if (currentLength == -1) {
            throw new RuntimeException("Книга не найдена!");
        }
        updateLengthShelves(currentLength);
    }

    private void updateLengthShelves(int currentLength) {
        if (quantityBooks > 0) {
            if (currentLength == lengthShelves) {
                lengthShelves = books[0].getInfoLength();
                for (int i = 1; i < quantityBooks; i++) {
                    lengthShelves = Math.max(lengthShelves, books[i].getInfoLength());
                }
            }
        } else {
            lengthShelves = 0;
        }
    }

    public void clearBookshelf() {
        Arrays.fill(books, 0, quantityBooks, null);
        quantityBooks = 0;
        lengthShelves = 0;
    }
}
