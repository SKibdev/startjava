package com.startjava.lesson_2_3_4.guess;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessNumber {
    public static final int QUANTITY_PLAYERS = 3;
    public static final int QUANTITY_ROUNDS = 3;
    public static final int QUANTITY_ATTEMPTS = 2;
    public static final int MAX = 100;
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
            mysteryNumber = (int) ((Math.random() * MAX) + 1);
            System.out.println("РАУНД № " + i);
            startRound();
            for (Player player : players) {
                showNumbers(player);
                player.clear();
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
                isNext = isAttempt(player);
            }
        }
    }

    private boolean isGuessed(Player player) {
        int playerNumber = enterNumber(player);

        if (playerNumber == mysteryNumber) {
            System.out.println("Игрок " + player.getName() + " угадал число " + mysteryNumber + " с "
                    + player.getAttempt() + " попытки");
            player.incrementScore();
            return true;
        }

        String resultComparison = playerNumber > mysteryNumber ? " больше" : " меньше";
        System.out.println("Число " + playerNumber + resultComparison + " того, что загадал компьютер\n");
        return false;
    }

    private boolean isAttempt(Player player) {
        if (player.getAttempt() == QUANTITY_ATTEMPTS) {
            System.out.println("У игрока " + player.getName() + " закончились попытки\n");
            return false;
        }
        return true;
    }

    public int enterNumber(Player player) {
        System.out.println("Игрок " + player.getName() + " введите целое число в полуинтервале (0, 100]: ");
        try {
            player.setNumber(input.nextInt());
        } catch (RuntimeException e) {
            input.nextLine();
            if (e instanceof InputMismatchException) {
                System.out.println("Вводите целые числа! Попробуйте еще раз!");
            } else {
                System.out.println(e.getMessage());
            }
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
        Player winner = players[0];

        for (int i = 1; i < players.length; i++) {
            int playerScore = players[i].getScore();
            int winnerScore = winner.getScore();
            if (playerScore == winnerScore) {
                winner.setName(winner + ", " + players[i]);
            } else {
                winner = playerScore > winnerScore ? players[i] : winner;
            }
        }

        System.out.print("\nПо итогу 3 раундов ");

        if (winner.getScore() == 0) {
            System.out.println("победителя нет!\nНикто из игроков не выиграл не одного раунда");
        } else {
            String resultGame = winner.getName().contains(",") ?
                    "игра закончилась в ничью!\nОдинаковое количество выгранных раундов у игроков: " :
                    "победителем игры стал игрок: ";
            System.out.println(resultGame + winner +
                    "\nКоличество выгранных раундов: " + winner.getScore());
        }
    }
}