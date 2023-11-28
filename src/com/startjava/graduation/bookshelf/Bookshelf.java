package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {
    private static int quantityBooks;
    private static int shelfLength;
    private final static Book[] books = new Book[10];

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

    public static Book getBook(int index) {
        return books[index];
    }

    public static void setBook(String author, String title, int year) {
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
        int tmpLength = books[indexDel].getInfoLength();
        //Удаляем книгу
        if (quantityBooks > 1 && indexDel < (books.length - 1)) {
            System.arraycopy(books, (indexDel + 1), books, indexDel, (quantityBooks - (indexDel + 1)));
            books[quantityBooks - 1] = null;
            quantityBooks--;
        } else {
            books[indexDel] = null;
            quantityBooks--;
            if (indexDel == 0) {

            }
        }
        //Корректируем длину шкафа
        if (quantityBooks > 0) {
            if (tmpLength == shelfLength) {
                int[] maxLength = new int[quantityBooks];
                for (int i = 0; i < quantityBooks; i++) {
                    maxLength[i] = books[i].getInfoLength();
                }
                Arrays.sort(maxLength);
                shelfLength = maxLength[quantityBooks - 1];
            }
        } else {
            shelfLength = 0;
        }
        System.out.println("Книга успешно удалена!");
    }

    public static void clearBookshelf() {
        for (int i = 0; i < quantityBooks; i++) {
            books[i] = null;
        }
        quantityBooks = 0;
        shelfLength = 0;
        System.out.println("Все книги из шкафа удалены!!!");
    }

    public static int getBookLength() {
        return books.length;
    }

    public static int getFreeShelves() {
        return books.length - quantityBooks;
    }

    public static Book[] getAllBooks() {
        Book[] allBooks = new Book[quantityBooks];
        System.arraycopy(books, 0, allBooks, 0, quantityBooks);
        return allBooks;
    }
}
