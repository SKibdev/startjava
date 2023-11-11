package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Scanner;

public class GuessNumber {

    private Player player1;
    private Player player2;
    private int mysteryNumber;
    private boolean isNext = true;


    public GuessNumber(String player1, String player2) {
        this.player1 = new Player(player1);
        this.player2 = new Player(player2);
    }

    public void start() {
        System.out.println("Игра началась! У каждого игрока по 10 попыток.");
        //TO DO mysteryNumber = (int) ((Math.random() * 100) + 1);
        mysteryNumber = 5;
        //TO DO надо избавиться от повторов в коде
        while (isNext) {
            if (playRound(player1)) {
                break;
            } if (checkIndex(player1)) {
                isNext = false;
            } if (playRound(player2)) {
                break;
            } if (checkIndex(player2)) {
                isNext = false;
            }
        }
        showAttempts(player1);
        showAttempts(player2);
    }
    private boolean checkIndex(Player player) {
        if (player.getIndex() == 2) {
            System.out.println("У " + player.getName() + " закончились попытки");
            return true;
        }
        return false;
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
            System.out.println("Игрок " + player.getName() + " угадал " + mysteryNumber + " с " + (player.getIndex() + 1) + " попытки\n");
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
        System.out.println("Все попытки игрока " + player.getName() + ":\n" + Arrays.toString(copyNumbers));
    }

}