package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    private static final int MAX = 100;
    private final String name;
    private final int[] numbers = new int[GuessNumber.QUANTITY_ATTEMPTS];
    private int attempt;
    private int numberVictories;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int numberVictories) {
        this.name = name;
        this.numberVictories = numberVictories;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return numbers[attempt - 1];
    }

    public void setNumber(int number) {
        if (number <= 0 || number > MAX) {
            throw new RuntimeException();
        }
        numbers[attempt++] = number;
    }

    public int getAttempt() {
        return attempt;
    }

    public int getNumberVictories() {
        return numberVictories;
    }

    public void setNumberVictories(int numberVictories) {
        this.numberVictories = numberVictories;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, attempt);
    }

    public void  clearNumbers() {
        Arrays.fill(numbers, 0, attempt, 0);
        attempt = 0;
    }

    @Override
    public String toString() {
        return name;
    }
}