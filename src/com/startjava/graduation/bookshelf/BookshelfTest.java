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
                isNext = openMenu();
                if (isNext) {
                    showBookshelf();
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                pressEnter();
            }
        }
    }

    private static boolean openMenu() {
        showMenu();
        switch (enterMenuItem()) {
            case 1 -> addBook();
            case 2 -> findBook();
            case 3 -> deleteBook();
            case 4 -> clearBookshelf();
            case 5 -> {
                return false;
            }
            default -> throw new RuntimeException("Ошибка! Такого пункта меню не существует!");
        }
        pressEnter();
        return true;
    }

    private static void showMenu() {
            System.out.println("\nВ шкафу книг - " + bookshelf.getQuantityBooks() +
                ", свободно полок - " + bookshelf.getFreeShelves() + "\n");
        System.out.println(""" 
                      Меню\s
                1. Добавить книгу
                2. Найти книгу
                3. Удалить книгу
                4. Очистить шкаф
                5. Завершить
                
                Введите выбранный пункт меню:\s""");
    }

    private static int enterMenuItem() {
        try {
            int menuItem = console.nextInt();
            console.nextLine();
            return menuItem;
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Ошибка! При работе с меню необходимо ввести номер операции!");
        }
    }

    private static void addBook() {
        if (bookshelf.getQuantityBooks() < bookshelf.getBookLength()) {
            System.out.println("Введите автора книги");
            String author = console.nextLine();
            System.out.println("Введите название книги");
            String title = console.nextLine();
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
        checkQuantityBooks();
        System.out.print("ПОИСК");
        System.out.println("Результат поиска:\n" + bookshelf.findBook(enterTitle()));
    }

    private static void deleteBook() {
        checkQuantityBooks();
        System.out.print("УДАЛЕНИЕ");
        System.out.println("Книга " + bookshelf.deleteBook(enterTitle()) + " успешно удалена!");
    }

    private static void clearBookshelf() {
        checkQuantityBooks();
        bookshelf.clearBookshelf();
        System.out.println("Все книги из шкафа удалены!!!");
    }

    private static String enterTitle() {
        System.out.println(" КНИГИ\nВведите название книги: ");
        String title = console.nextLine();
        if (title.equals("") || title.equals(" ")) {
            throw new RuntimeException("Вы ввели пустой поисковый запрос!");
        }
        return title;
    }

    private static void checkQuantityBooks() {
        if (bookshelf.getQuantityBooks() == 0) {
            throw new RuntimeException ("\nШкаф пуст. Вы можете добавить в него первую книгу\n");
        }
    }

    private static void pressEnter() {
        System.out.print("\nДля продолжения нажмите Enter");
        if (console.nextLine() != "") {
            console.nextLine();
        }
    }

    private static void showBookshelf() {
        checkQuantityBooks();
        System.out.println("\nВ шкафу книг - " + bookshelf.getQuantityBooks() +
                ", свободно полок - " + bookshelf.getFreeShelves() + "\n");
        Book[] allBooks = bookshelf.getAllBooks();
        for (Book allBook : allBooks) {
            String spaces = " ".repeat((bookshelf.getShelfLength() - allBook.getInfoLength()));
            String minus = "-".repeat(bookshelf.getShelfLength());
            System.out.println("|" + allBook + spaces + "|\n|" + minus + "|");
        }
        pressEnter();
    }
}
