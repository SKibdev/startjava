package com.startjava.graduation.bookshelf;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookshelfTest {
    static Scanner console = new Scanner(System.in);
    static Bookshelf bookshelf = new Bookshelf();

    public static void main(String[] args) {
        System.out.println("""
                
                ДОБРО ПОЖАЛОВАТЬ В ПРОГРАММУ
                        КНИЖНЫЙ ШКАФ""");
        boolean isNext = true;

        while (isNext) {
            try {
                if (bookshelf.getQuantityBooks() > 0) {
                    showBookshelf();
                }
                isNext = openBookshelf();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                pressEnter();
            }
        }
    }

    private static boolean openBookshelf() {
        showMenu();
        switch (enterMenuItem()) {
            case 1 -> saveBook();
            case 2 -> findBook();
            case 3 -> deleteBook();
            case 4 -> clearBookshelf();
            case 5 -> {
                return false;
            }
            default -> throw new RuntimeException("Ошибка! Введен не сущетсвующий порядковый номер пункта меню!");
        }
        pressEnter();
        return true;
    }

    private static void showMenu() {
        System.out.println(""" 
                      
                      Меню\s
                1. Добавить книгу
                2. Найти книгу
                3. Удалить книгу
                4. Очистить шкаф
                5. Завершить
                
                Введите порядковый номер пункта меню:\s""");
    }

    private static int enterMenuItem() {
        try {
            int menuItem = console.nextInt();
            console.nextLine();
            if (bookshelf.getQuantityBooks() == 0 && (menuItem > 1 && menuItem < 5)) {
                throw new RuntimeException ("\nШкаф пуст. Вы можете добавить в него первую книгу\n");
            }
            return menuItem;
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Ошибка! Необходимо ввести порядковый номер пункта меню!");
        }
    }

    private static void saveBook() {
        if (bookshelf.getQuantityBooks() < Bookshelf.BOOKS_LIMIT) {
            System.out.println("Введите автора книги");
            String author = console.nextLine();
            String title = enterTitle();
            System.out.println("Введите год издания");
            int yearPublication;
            try {
                yearPublication = console.nextInt();
            } catch (RuntimeException e) {
                throw new RuntimeException("Ошибка! Книга не добавлена! Год издания вводите в числовом формате!");
            }
            //Добавлено, чтобы избежать ввода лишнего "\n" после nextInt();
            console.nextLine();
            bookshelf.save(new Book(author, title, yearPublication));
            System.out.println("Книга добавлена успешно!");
        } else {
            System.out.println("Невозможно добавить книгу! В шкафу нет пустых полок!");
        }
    }

    private static void findBook() {
        System.out.println("ПОИСК КНИГИ");
        System.out.println("Результат поиска:\n" + bookshelf.find(enterTitle()));
    }

    private static void deleteBook() {
        System.out.println("УДАЛЕНИЕ КНИГИ");
        bookshelf.delete(enterTitle());
        System.out.println("Книга успешно удалена!");
    }

    private static void clearBookshelf() {
        bookshelf.clearBookshelf();
        System.out.println("Все книги из шкафа удалены!!!");
    }

    private static String enterTitle() {
        System.out.println("Введите название книги: ");
        String title = console.nextLine();
        if (title.equals("") || title.equals(" ")) {
            throw new RuntimeException("Вы ввели пустую стироку!");
        }
        return title;
    }

    private static void pressEnter() {
        System.out.print("\nДля продолжения нажмите Enter");
        if (console.nextLine() != "") {
            console.nextLine();
        }
    }

    private static void showBookshelf() {
        System.out.println("\nВ шкафу книг - " + bookshelf.getQuantityBooks() +
                ", свободно полок - " + bookshelf.getFreeShelves() + "\n");
        Book[] allBooks = bookshelf.getAllBooks();
        for (Book book : allBooks) {
            String spaces = " ".repeat((bookshelf.getLengthShelves() - book.getInfoLength()));
            String minus = "-".repeat(bookshelf.getLengthShelves());
            System.out.println("|" + book + spaces + "|\n|" + minus + "|");
        }
        pressEnter();
    }
}
