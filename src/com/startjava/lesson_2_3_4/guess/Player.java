package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    private String name;
    private int[] numbers = new int[10];
    private int attempt = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return numbers[attempt - 1];
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void addNumber(int number) {
        numbers[attempt++] = number;
    }

    public int getAttempt() {
        return attempt;
    }

    public void showAttempts() {
        int[] copyNumbers = Arrays.copyOf(numbers, attempt);

        for (int i = 0; i < attempt; i++) {
            System.out.print(copyNumbers[i] + " ");
        }
        System.out.println();
        Arrays.fill(numbers, 0, attempt, 0);
    }
}