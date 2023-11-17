package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    
    public static void main(String[] args) {
        String answer = "yes";
        // Если в терминале не отображается кириллица, то необходимо добавить "cp866": Scanner(System.in, "cp866")
        Scanner input = new Scanner(System.in);
        printRules();
        System.out.println("Введите имя Игрока 1: ");
        String namePlayer1 = input.nextLine();
        System.out.println("Введите имя Игрока 2: ");
        String namePlayer2 = input.nextLine();

        do {
            if (answer.equals("yes")) {
                GuessNumber game = new GuessNumber(namePlayer1, namePlayer2);
                game.start();
            }

            System.out.println("\nХотите продолжить игру? [yes/no]: ");
            answer = input.nextLine();
        } while (!answer.equals("no"));

        input.close();
    }

    private static void printRules() {
        System.out.println("""

                    Добро пожаловать в игру УГАДАЙ ЧИСЛО\s

                КРАТКИЕ ПРАВИЛА

                1. В игре участвуют два игрока, которые по очереди будут пытаться угадать\s
                число, загаданное компьютером, вводя его с клавиатуры\s
                2. ход к следующему игроку переходит после неудачного угадывания текущего игрока\s
                3. Одержать победу может только один игрок\s
                4. Игра продолжается до тех пор, пока число не будет угадано
                5. В игре должны использоваться только целые положительные числа в полуинтервале (0, 100]
                """);
    }
}