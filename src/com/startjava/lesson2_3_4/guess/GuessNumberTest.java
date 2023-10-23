package com.startjava.lesson2_3.guess;

import java.util.Scanner;

public class GuessNumberTest {
    
    public static void main(String[] args) {
        String answer = "";
        Scanner input = new Scanner(System.in, "cp866");

        System.out.println("\n    Добро пожаловать в игру УГАДАЙ ЧИСЛО \n\nКРАТКИЕ ПРАВИЛА" + 
                "\n\n1. В игре участвуют два игрока, которые по очереди будут пытаться угадать " + 
                "\nчисло, загаданное компьютером, вводя его с клавиатуры " + 
                "\n2. ход к следующему игроку переходит после неудачного угадывания " + 
                "текущего игрока \n3. Одержать победу может только один игрок " + 
                "\n4. Игра продолжается до тех пор, пока число не будет угадано" + 
                "\n5. В игре должны использоваться только целые положительные числа " + 
                "в полуинтервале (0, 100]\n");
        System.out.println("Введите имя Игрока 1: ");
        Player player1 = new Player(input.nextLine());
        System.out.println("Введите имя Игрока 2: ");
        Player player2 = new Player(input.nextLine());
        System.out.println("\nИГРА НАЧАЛАСЬ\n");

        do {
            GuessNumber game = new GuessNumber(player1, player2);
            game.start();
            do {
                System.out.println("Хотите продолжить игру? [yes/no]: ");
                answer = input.nextLine();
            } while (!answer.equals("yes") && !answer.equals("no"));
        } while (!answer.equals("no"));

        input.close();
    }
}