package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {
    public static final int QUANTITY_PLAYERS = 3;
    public static final int QUANTITY_ROUNDS = 3;
    public static final int QUANTITY_ATTEMPTS = 10;
    private final Player[] players = new Player[QUANTITY_PLAYERS];
    private final Scanner input = new Scanner(System.in);
    private int mysteryNumber;

    public GuessNumber(String[] names) {
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(names[i]);
        }
    }

    public void start() {
        System.out.println("\nИгра началась! В игре 3 раунда.\nВ каждом раунде у каждого игрока будет 10 попыток");
        castLots();
        startGameplay();
        chooseWinner();
    }

    private void castLots() {
        for (int i = players.length - 1; i >= 1; i--) {
            int position = (int) (Math.random() * i);
            Player temp = players[position];
            players[position] = players[i];
            players[i] = temp;
        }
        System.out.println("Жеребьевка определила следующий порядок участия игроков:");
        for (Player player : players) {
            System.out.println(player);
        }
    }

    private void startGameplay() {

        for (int i = 1; i <= QUANTITY_ROUNDS; i++) {
            mysteryNumber = (int) ((Math.random() * 100) + 1);
            System.out.println("РАУНД № " + i);
            startRound();
            for (Player player : players) {
                showNumbers(player);
                player.clearNumbers();
            }
        }
    }

    private void startRound() {
        boolean isNext = true;
        while (isNext) {
            for (Player player : players) {
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
    }

    private boolean isGuessed(Player player) {
        int playerNumber = enterNumber(player);

        if (playerNumber == mysteryNumber) {
            System.out.println("Игрок " + player.getName() + " угадал число " + mysteryNumber + " с "
                    + player.getAttempt() + " попытки");
            player.setNumberVictories(player.getNumberVictories() + 1);
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
        } catch (RuntimeException e) {
            input.nextLine();
            System.out.println("Ошибка! Попробуйте еще раз!");
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

    private void chooseWinner() {
        Player winner = new Player("не определен!");
        for (Player player : players) {
            int playerNumberVictories = player.getNumberVictories();
            int winnerNumberVictories = winner.getNumberVictories();
            if (playerNumberVictories == winnerNumberVictories) {
                winner = new Player("не определен!", playerNumberVictories);
            } else {
                winner = playerNumberVictories > winnerNumberVictories ? player : winner;
            }
        }
        System.out.println("По итогу 3 раундов победитель игры: " + winner);
    }
}