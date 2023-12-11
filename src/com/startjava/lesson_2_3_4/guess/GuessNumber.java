package com.startjava.lesson_2_3_4.guess;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessNumber {
    public static final int QUANTITY_PLAYERS = 3;
    public static final int QUANTITY_ROUNDS = 3;
    private final Player[] players = new Player[QUANTITY_PLAYERS];
    private final Scanner input = new Scanner(System.in);
    private int mysteryNumber;

    public GuessNumber(String[] names) {
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(names[i]);
        }
    }

    public void start() {
        System.out.println("\nИгра началась! В игре 3 раунда.\n");
        mysteryNumber = (int) ((Math.random() * 100) + 1);
        castLots();
        playGame();

        for (Player player : players) {
            showNumbers(player);
            player.clearNumbers();
        }
    }

    private void castLots() {
        for (int i = players.length - 1; i >= 1; i--) {
            int position = (int) ((Math.random() * i));
            Player temp = players[position];
            players[position] = players[i];
            players[i] = temp;
        }
        System.out.println("Жеребьевка определила следующий порядок участия игроков:");
        for (Player player : players) {
            System.out.println(player);
        }
    }

    private void playGame() {
        try {
            for (int i = 1; i <= QUANTITY_ROUNDS; i++) {
                System.out.println("РАУНД № " + i);
                for (Player player : players) {
                    if (isGuessed(player)) {
                        throw new RuntimeException("Игрок " + player.getName() + " угадал число " + mysteryNumber +
                                " с " + (player.getAttempt()) + " попытки\n");
                    } else if (i == QUANTITY_ROUNDS) {
                        System.out.println("В ходе 3 раундов победитель не был выявлен!!!");
                    }

                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean isGuessed(Player player) {
        int playerNumber = enterNumber(player);

        if (playerNumber == mysteryNumber) {
            return true;
        }
        String resultComparison = playerNumber > mysteryNumber ? " больше" : " меньше";
        System.out.println("Число " + playerNumber + resultComparison + " того, что загадал компьютер\n");
        return false;
    }

    public int enterNumber(Player player) {
        System.out.println("Игрок " + player.getName() + " введите целое число в полуинтервале (0, 100]: ");
        try {
            player.setNumber(input.nextInt());
        } catch (InputMismatchException e) {
            input.nextLine();
            System.out.println("Ошибка! Вводите целые числа!");
            enterNumber(player);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            enterNumber(player);
        }
        return player.getNumber();
    }

    private void showNumbers(Player player) {
        System.out.print("Все попытки игрока " + player + ": ");
        for (int attempt : player.getNumbers()) {
            System.out.print(attempt + " ");
        }
        System.out.println();
    }
}