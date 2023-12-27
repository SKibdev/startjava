package com.startjava.graduation.bookshelf;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookshelfTest {
    // В текст внесены комментарии по результату разбора эталлоного кода
    static Scanner console = new Scanner(System.in);
    static Bookshelf bookshelf = new Bookshelf();

    public static void main(String[] args) {
        System.out.println("""
                
                ДОБРО ПОЖАЛОВАТЬ В ПРОГРАММУ
                        КНИЖНЫЙ ШКАФ""");
        boolean isNext = true;

        while (isNext) {
            try {
                showBookshelf();
                isNext = startInterface();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                pressEnter();
            }
        }
    }

    private static void showBookshelf() {
        if (bookshelf.getQuantityBooks() > 0) {
            System.out.println("\nВ шкафу книг - " + bookshelf.getQuantityBooks() +
                    ", свободно полок - " + bookshelf.getFreeShelves() + "\n");
            Book[] allBooks = bookshelf.getAllBooks();
            for (Book book : allBooks) {
                String spaces = " ".repeat((bookshelf.getLengthShelves() - book.getInfoLength()));
                String minus = "-".repeat(bookshelf.getLengthShelves());
                System.out.println("|" + book + spaces + "|\n|" + minus + "|");
            }
        } else {
            System.out.println("\nШкаф пуст. Вы можете добавить в него первую книгу");
        }
    }

    private static boolean startInterface() {
        showMenu();
        // если item сделать String, то можно уйти от InputMismatchException
        switch (enterMenuItem()) {
            case 1 -> saveBook();
            case 2 -> findBook();
            case 3 -> deleteBook();
            case 4 -> clearBookshelf();
            case 5 -> { return false; }
            default -> throw new RuntimeException("Ошибка! Введен не существующий порядковый номер пункта меню!");
        }
        pressEnter();
        return true;
    }

    private static void showMenu() {
        System.out.print(""" 
                      
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
                throw new RuntimeException ("Ошибка! В шкафу нет книг!");
            }
            return menuItem;
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Ошибка! Необходимо ввести порядковый номер пункта меню!");
        }
    }

    private static void saveBook() {
        if (bookshelf.getQuantityBooks() < Bookshelf.BOOKS_LIMIT) {
            System.out.print("Введите автора книги: ");
            String author = console.nextLine();
            String title = enterTitle();
            System.out.print("Введите год издания: ");
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
        // Можно через тернарный оператор обрабатывать возвращаемые ответы от методов слоя логики
        // String message = bs.delete(input(MESSAGE_TITLE)) ? "Книга удалена." : "Книга не найдена.";
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
        System.out.print("Введите название книги: ");
        String title = console.nextLine();
        if (title.equals("") || title.equals(" ")) {
            throw new RuntimeException("Вы ввели пустую строку!");
        }
        return title;
    }

    private static void pressEnter() {
//        Этот вариант тоже работает, с одни отличием, если ввести какие то символы и <Enter>
//        то на второй раз после нажатия <Enter> программа будет работать дальше
//        System.out.print("\nДля продолжения нажмите Enter");
//        if (console.nextLine() != "") {
//            console.nextLine();
//        }
        //В этом варианте пока не будет нажат <Enter> с пустой строкой дальше не сдвинемся
        String key;
        do {
            System.out.print("\nДля продолжения работы нажмите клавишу <Enter>");
            key = console.nextLine();
        } while (!key.isEmpty());
    }
}
