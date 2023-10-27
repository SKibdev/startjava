package com.startjava.lesson2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {

    private Player player1;
    private Player player2;
    private int mysteryNumber;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        mysteryNumber = (int) ((Math.random() * 100) + 1);
        boolean winner = false;
        while(!winner) {
            winner = playRound(player1) ? true : playRound(player2);
        }
    }

    private int enterNumber(Player player) {
        Scanner console = new Scanner(System.in);
        System.out.println(player.getName() + 
                "\nвведите целое число в полуинтервале (0, 100]: ");
        player.setNumber(console.nextInt());
        return player.getNumber();
    }

    private boolean playRound(Player player) {
        int playerNumber = enterNumber(player);

        if (playerNumber <= 0 || playerNumber > 100) {
            System.out.println("Переход хода!Необходимо вводить число в полуинтервале (0, 100]!\n");
        } else if (playerNumber < mysteryNumber) {
            System.out.println("Число " + playerNumber + " меньше того, что загадал компьютер\n");
        } else if (playerNumber > mysteryNumber) {
            System.out.println("Число " + playerNumber + " больше того, что загадал компьютер\n");
        } else {
            System.out.println(player.getName() + " победил!!!\n");
            return true;
        }
        return false;
    }
}