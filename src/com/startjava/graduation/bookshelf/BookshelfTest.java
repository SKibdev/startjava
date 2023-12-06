package com.startjava.graduation.bookshelf;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookshelfTest {
    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("""
                
                ДОБРО ПОЖАЛОВАТЬ В ПРОГРАММУ
                        КНИЖНЫЙ ШКАФ""");
        boolean isNext = true;

        while (isNext) {
            try {
                isNext = runMenu();
                if (isNext) {
                    visualizationBookshelf();
                    pressEnter();
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                pressEnter();
            }
        }
    }

    private static boolean runMenu() {
        visualizationMenu();
        int menuItem;
        try {
            menuItem = console.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Ошибка! При работе с меню необходимо ввести номер операции!");
        }
        console.nextLine();
        switch (menuItem) {
            case 1 -> {
                executeAddBook();
                pressEnter();
            }
            case 2 -> {
                checkQuantityBooks();
                System.out.print("ПОИСК");
                System.out.println("Результат поиска:" + "\n" + Bookshelf.getBook(find()));
                pressEnter();
            }
            case 3 -> {
                checkQuantityBooks();
                System.out.print("УДАЛЕНИЕ");
                delete();
                pressEnter();
            }
            case 4 -> {
                checkQuantityBooks();
                Bookshelf.clearBookshelf();
                System.out.println("Все книги из шкафа удалены!!!");
            }
            case 5 -> {
                return false;
            }
            default -> throw new RuntimeException("Ошибка! Такой операции нет! Попробуйте еще раз!");
        }
        return true;
    }

    private static void visualizationMenu() {
        if (Bookshelf.getQuantityBooks() == 0) {
            System.out.println("\nШкаф пуст. Вы можете добавить в него первую книгу\n");
        } else {
            System.out.println("""
                \nВ шкафу книг -\s""" + Bookshelf.getQuantityBooks() + """ 
                , свободно полок -\s""" + Bookshelf.getFreeShelves() + "\n");
        }
        System.out.println(""" 
                      Меню\s
                1. Добавить книгу
                2. Найти книгу
                3. Удалить книгу
                4. Очистить шкаф
                5. Завершить
                
                Введите выбранный пункт меню:\s""");
    }

    private static void executeAddBook() throws InputMismatchException {
        if (Bookshelf.getQuantityBooks() < Bookshelf.getBookLength()) {
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
            // 4 - это длина разделителей "' "
            int infoLength = author.length() + title.length() + String.valueOf(yearPublication).length() + 4;
            Bookshelf.setBook(new Book(author, title, yearPublication, infoLength));
            System.out.println("Книга добавлена успешно!");
        } else {
            System.out.println("Невозможно добавить книгу! В шкафу нет пустых полок!");
        }
    }

    private static void pressEnter() {
        System.out.print("\nДля продолжения нажмите Enter");
        if (console.nextLine() != "") {
            console.nextLine();
        }
    }

    private static void checkQuantityBooks() {
        if (Bookshelf.getQuantityBooks() == 0) {
            throw new RuntimeException ("\nШкаф пуст. Вы можете добавить в него первую книгу");
        }
    }

    private static int find() {
        System.out.println(" КНИГИ\nВведите название книги: ");
        String title = console.nextLine();
        return Bookshelf.find(title);
    }

    private static void delete() {
        int searchIndex = find();
        System.out.println("Для подтверждения удаления книги введите \"да\" и нажмите Enter: \n" + Bookshelf.getBook(searchIndex));
        if (console.nextLine().equals("да")) {
            Bookshelf.delete(searchIndex);
            System.out.println("Книга успешно удалена!");
        } else {
            System.out.println("Вы отменили удаление книги!");
        }
    }

    private static void visualizationBookshelf() {
        checkQuantityBooks();
        System.out.println("""
             \nВ шкафу книг -\s""" + Bookshelf.getQuantityBooks() + """ 
             , свободно полок -\s""" + Bookshelf.getFreeShelves() + "\n");
        Book[] allBooks = Bookshelf.getAllBooks();
        for (Book allBook : allBooks) {
            String spaces = " ".repeat((Bookshelf.getShelfLength() - allBook.getInfoLength()));
            String minus = "-".repeat(Bookshelf.getShelfLength());
            System.out.println("|" + allBook + spaces + "|\n|" + minus + "|");
        }
    }
}
