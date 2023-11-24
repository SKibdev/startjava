package com.startjava.graduation.bookshelf;

import java.util.Scanner;

public class BookshelfTest {
// Если шкаф пустой, то методы удалить и найти выводят лишний раз надпись Для продолжения нажмите Enter
// TO DO Надо вывод длинных книг как то решить
    // Логику по выводу книг надо перенести из Book в Bookcase, чтобы название резалось во время вывода,
// а хранились полные данные о книги. А в идеале сразу сделать динамический шкаф.
    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("""
                
                ДОБРО ПОЖАЛОВАТЬ В ПРОГРАММУ
                        КНИЖНЫЙ ШКАФ""");

        while (runMenu()) {
            visualizationBookshelf();
            pressEnter();
        }
    }

    private static boolean runMenu() {
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

        int menuItem = console.nextInt();
        console.nextLine();
        switch (menuItem) {
            case 1 -> {
                displayAddBook();
                pressEnter();
            }
            case 2 -> {
                System.out.println("        ПОИСК КНИГИ\nВведите название книги: ");
                String searchQuery = console.nextLine();
                int searchIndex = Bookshelf.findBook(searchQuery);
                if (searchIndex == -1) {
                    System.out.println("Книга не найдена!");
                } else {
                    System.out.println("Результат поиска: \n" + Bookshelf.getBook(searchIndex));
                }
                pressEnter();
            }
            case 3 -> {
                System.out.println("УДАЛЕНИЕ КНИГИ\nВведите название книги: ");
                String searchQuery = console.nextLine();
                int searchIndex = Bookshelf.findBook(searchQuery);
                if (searchIndex == -1) {
                    System.out.println("Книга не найдена!");
                } else {
                    System.out.println("Удалить книгу: \n" + Bookshelf.getBook(searchIndex) +
                            "? (для подтверждения введите \"y\" иначе книга удалена не будет)");
                    if (console.nextLine().equals("y")) {
                        Bookshelf.deleteBook(searchIndex);
                        System.out.println("Книга успешно удалена!");
                    }
                }
                pressEnter();
            }
            case 4 -> {
                Bookshelf.clearBookshelf();
                System.out.println("Шкаф пуст");
            }
            case 5 -> {
                return false;
            }
            default -> System.out.print("Попробуйте еще раз");
        }
        return true;
    }

    private static void pressEnter() {
        System.out.print("\nДля продолжения нажмите Enter");
        if (console.nextLine() != "") {
            console.nextLine();
      }
    }

    private static void displayAddBook() {
        if (Bookshelf.getQuantityBooks() < 10) {
            System.out.println("Введите автора книги");
            String author = console.nextLine();
            System.out.println("Введите название книги");
            String title = console.nextLine();
            System.out.println("Введите год издания");
            int year = console.nextInt();
            //Добавлено, чтобы избежать ввода лишнего "\n" после nextInt();
            console.nextLine();
            Bookshelf.addBook(author, title, year);
            System.out.println("Книга добавлена!");
        } else {
            System.out.println("В шкафу нет пустых полок!");
        }
    }

    private static void visualizationBookshelf() {
        if (Bookshelf.getQuantityBooks() > 0) {
            System.out.println("""
                \nВ шкафу книг -\s""" + Bookshelf.getQuantityBooks() + """ 
                , свободно полок -\s""" + Bookshelf.getFreeShelves() + "\n\n" + Bookshelf.getAllBooks());
        }
    }



    /*
    TO DO
    Запуск
    "Шкаф пуст. Вы можете добавить в него первую книгу"
    После каждой выполненной операции выводите сообщение:
    "Для продолжения нажмите Enter"

Bookshelf.getNumberFreeShelves:
    В шкафу книг - 2, свободно полок - 8

Bookshelf.get all books:
|Ирвинг Стоун, Жажда жизни, 1973             |
|--------------------------------------------|
|Рэй Брэдбери, 451 градус по Фаренгейту, 1980|
|--------------------------------------------|
|                                            |

    menu
    Посмотреть содержимое шкафа
    Bookshelf.get all books + Bookshelf.getNumberFreeShelves

    Добавить книгу Bookshelf.addBook();
    Найти книгу Bookshelf.searchBook();
    Удалить книгу Bookshelf.deleteBook();
    Очистить шкаф Bookshelf.clearBookshelf();
    Завершить

    Класс для размещения меню, обработки выбора пользователя,
    ввода необходимой для работы методов класса Книжный шкаф информации
    и вывода возвращаемых ими данных

     */

}
