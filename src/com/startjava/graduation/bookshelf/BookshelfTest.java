package com.startjava.graduation.bookshelf;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookshelfTest {
    /*
    TO DO
    1.
    3. Логику по выводу книг надо перенести из Book в BookcaseTest, не резать книги, сделать динамический шкаф.+

        3.1 чтобы при выводе данных книги не перечислять все геттеры класса Book, реализуйте в нем метод toString()+
        3.2 чтобы вызывать у объекта метод toString() в println, достаточно написать имя объекта,
        и он вызовется автоматически.+
        3.3 для отображения полок можно использовать метод repeat().+
        3.4 класс Book и Bookshelf не должны содержать код, связанный с рисованием полки.+
    4. Надо все пункты меню оформить в отдельные методы и убрать дублирования кода.+
    5. Выстроить методы в правильном порядке.+
        5.1 методы в классе Книжный шкаф размещайте в том же порядке, в котором они идут в меню+
    6. Сделать обработку исключений.
        Выводите подходящие сообщения, если книга не была удалена, найдена, не может быть сохранена,
        т. к. на полке кончилось место или пользователь ввел недопустимую команду.
        При этом программа не должна падать.
     */

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
                find(false);
                pressEnter();
            }
            case 3 -> {
                checkQuantityBooks();
                find(true);
                pressEnter();
            }
            case 4 -> {
                checkQuantityBooks();
                Bookshelf.clearBookshelf();
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
            int year;
            try {
                year = console.nextInt();
            } catch (RuntimeException e) {
                throw new RuntimeException("Ошибка! Книга не добавлена! Год издания вводите в числовом формате!");
            }
            //Добавлено, чтобы избежать ввода лишнего "\n" после nextInt();
            console.nextLine();
            Bookshelf.setBook(author, title, year);
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

    private static void find(boolean isForDeletion) {
        System.out.println((isForDeletion ? "УДАЛЕНИЕ" : "ПОИСК") +
                " КНИГИ\nВведите название книги: ");
        String searchQuery = console.nextLine();
        int searchIndex = Bookshelf.findBook(searchQuery);
        if (searchIndex == -1) {
            System.out.println("Книга не найдена!");
        } else {
            if (isForDeletion) {
                System.out.println("Для подтверждения удаления книги введите \"да\" и нажмите Enter: \n" +
                        Bookshelf.getBook(searchIndex));
                if (console.nextLine().equals("да")) {
                    Bookshelf.deleteBook(searchIndex);
                } else {
                    System.out.println("Вы отменили удаление книги!");
                }
            } else {
                System.out.println("Результат поиска:" + "\n" + Bookshelf.getBook(searchIndex));
            }
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
