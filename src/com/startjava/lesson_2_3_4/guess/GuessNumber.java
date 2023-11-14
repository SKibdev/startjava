package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Scanner;

public class GuessNumber {

    private Player[] players = new Player[2];
    private int mysteryNumber;
    private boolean isNext = true;

    public GuessNumber(String player1, String player2) {
        players[0] = new Player(player1);
        players[1] = new Player(player2);
    }

    public void start() {
        System.out.println("\nИгра началась! У каждого игрока по 10 попыток.\n");
        //TO DO mysteryNumber = (int) ((Math.random() * 100) + 1);
        mysteryNumber = 5;

        while (isNext) {
            for (int i = 0; i < 2; i++) {
                if (playRound(players[i])) {
                    isNext = false;
                    break;
                }
                if (players[i].getIndex() == 2) {
                    System.out.println("У " + players[i].getName() + " закончились попытки\n");
                    isNext = false;
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            showAttempts(players[i]);
            cleanAttempts(players[i]);
        }
    }

    private boolean playRound(Player player) {

        int playerNumber = enterNumber(player);
        if (playerNumber <= 0 || playerNumber > 100) {
            System.out.println("Переход хода! Необходимо вводить число в полуинтервале (0, 100]!\n");
        } else if (playerNumber < mysteryNumber) {
            System.out.println("Число " + playerNumber + " меньше того, что загадал компьютер\n");
        } else if (playerNumber > mysteryNumber) {
            System.out.println("Число " + playerNumber + " больше того, что загадал компьютер\n");
        } else {
            System.out.println("Игрок " + player.getName() + " угадал число " + mysteryNumber + " с " + (player.getIndex() + 1) + " попытки\n");
            return true;
        }
        return false;
    }

    private int enterNumber(Player player) {
        Scanner console = new Scanner(System.in);
        System.out.println(player.getName() +
                "\nвведите целое число в полуинтервале (0, 100]: ");
        player.addNumber(console.nextInt());
        return player.getNumber();
    }

    private void showAttempts(Player player) {
        int[] copyNumbers = Arrays.copyOf(player.getNumbers(), player.getIndex() + 1);
        //TO DO переделать метод вывода
        System.out.println("\nВсе попытки игрока " + player.getName() + ": ");
        for (int i = 0; i <= player.getIndex(); i++) {
            System.out.print(copyNumbers[i] + " ");
        }
    }

    private void cleanAttempts(Player player) {
        Arrays.fill(player.getNumbers(), 0, (player.getIndex() + 1), 0);
    }
}