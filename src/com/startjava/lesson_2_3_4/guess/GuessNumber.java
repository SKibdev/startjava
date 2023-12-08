package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private static final int QUANTITY_ATTEMPTS = 3;
    private final Player[] players = new Player[3];
    private Player[] playersDraw = new Player[3];
    private int mysteryNumber;


    public GuessNumber(String player1, String player2, String player3) {
        players[0] = new Player(player1);
        players[1] = new Player(player2);
        players[2] = new Player(player3);
    }

    public void start() {
        System.out.println("\nИгра началась! В  игре 3 раунда.\n");
        boolean isNext = true;
        mysteryNumber = (int) ((Math.random() * 100) + 1);
        castLots();

        while (isNext) {
            for (Player player : playersDraw) {
                if (isGuessed(player)) {
                    isNext = false;
                    break;
                }
                if (player.getAttempt() == QUANTITY_ATTEMPTS) {
                    System.out.println("У игрока " + player.getName() + " закончились попытки\n");
                    isNext = false;
                }
            }
        }

        for (Player player : players) {
            showAttempts(player);
            player.clearAttempts();
        }
    }

    private void castLots() {
        playersDraw = Arrays.copyOf(players, players.length);
        for (int i = playersDraw.length - 1; i >= 1; i--) {
            int j = new Random().nextInt(i + 1);
            Player temp = playersDraw[i];
            playersDraw[i] = playersDraw[j];
            playersDraw[j] = temp;
        }
        System.out.println("Жеребьевка определила следующий порядок участия игроков: \n" + playersDraw[0] +
                "\n" + playersDraw[1] + "\n" + playersDraw[2]);
    }

    private boolean isGuessed(Player player) {
        int playerNumber = enterNumber(player);

        if (playerNumber == mysteryNumber) {
            System.out.println("Игрок " + player.getName() + " угадал число " + mysteryNumber +
                    " с " + (player.getAttempt()) + " попытки\n");
            return true;
        } else {
            String resultComparison = playerNumber > mysteryNumber ?
                    " больше того, что загадал компьютер\n" : " меньше того, что загадал компьютер\n";
            System.out.println("Число " + playerNumber + resultComparison);
            return false;
        }
    }

    public int enterNumber(Player player) {
        Scanner console = new Scanner(System.in);
        System.out.println("Игрок " + player.getName() + " введите целое число в полуинтервале (0, 100]: ");
        try {
            player.setNumber(console.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Ошибка! Вводите целые числа!");
            enterNumber(player);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            enterNumber(player);
        }
        return player.getNumber();
    }

    private void showAttempts(Player player) {
        for (int attempt : player.getAttempts()) {
            System.out.print(attempt + " ");
        }
        System.out.println();
    }
}