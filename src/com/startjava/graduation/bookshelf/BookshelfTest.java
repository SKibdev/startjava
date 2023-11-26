package com.startjava.graduation.bookshelf;

import java.util.Scanner;

public class BookshelfTest {
    /*
    TO DO
    1. Не работает удаление - удаляется только последний элемнт, что-то не так копируется.
    3. Логику по выводу книг надо перенести из Book в BookcaseTest, не резать книги, сделать динамический шкаф.
        Добавил наибольшую длину в Воок.

        3.1 чтобы при выводе данных книги не перечислять все геттеры класса Book, реализуйте в нем метод toString()
        3.2 чтобы вызывать у объекта метод toString() в println, достаточно написать имя объекта,
        и он вызовется автоматически.
        3.3 для отображения полок можно использовать метод repeat().
        3.4 класс Book и Bookshelf не должны содержать код, связанный с рисованием полки.
    4. Надо все пункты меню оформить в отдельные методы и убрать дублирования кода.
    5. Выстроить методы в правильном порядке.
        5.1 методы в классе Книжный шкаф размещайте в том же порядке, в котором они идут в меню
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
                executeAddBook();
                pressEnter();
            }
            case 2 -> {
                if (Bookshelf.getQuantityBooks() == 0) {
                    break;
                }
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
                if (Bookshelf.getQuantityBooks() == 0) {
                    break;
                }
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
                    }
                }
                pressEnter();
            }
            case 4 -> Bookshelf.clearBookshelf();
            case 5 -> {
                return false;
            }
            default -> throw new RuntimeException("Попробуйте еще раз");
        }
        return true;
    }

    private static void pressEnter() {
        System.out.print("\nДля продолжения нажмите Enter");
        if (console.nextLine() != "") {
            console.nextLine();
      }
    }

    private static void executeAddBook() {
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
        } else {
            System.out.println("В шкафу нет пустых полок!");
        }
    }

    private static void visualizationBookshelf() {
        if (Bookshelf.getQuantityBooks() > 0) {
            System.out.println("""
                \nВ шкафу книг -\s""" + Bookshelf.getQuantityBooks() + """ 
                , свободно полок -\s""" + Bookshelf.getFreeShelves() + "\n");
            Book[] allBooks = Bookshelf.getAllBooks();
            for (Book allBook : allBooks) {
                String spaces = " ".repeat(Bookshelf.getShelfLength() - allBook.getInfoLength());
                String minus = "-".repeat(Bookshelf.getShelfLength());
                System.out.println("|" + allBook + spaces + "|\n|" + minus + "|");
            }
        } else {
            System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу!!!");
        }
    }
/*
// Добавляем недостающие пробелы для выравнивания полки
        // Количесвто пробелов = длина шкафа 44 символа - длина информации о книге + 4 длина разделитейлей ", "
        int quantitySpace = 44 - (informationLength + 4);
        String spaceStr = "";
             for (int i = 1; i <= quantitySpace; i++) {
                spaceStr += " ";
            }

        return "|" + author + ", " + title + ", " + year + spaceStr +
                "|\n|--------------------------------------------|\n";
 */


    /*


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
