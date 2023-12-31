package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private final String name;
    private final int[] numbers = new int[GuessNumber.QUANTITY_ATTEMPTS];
    private int attempt;
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return numbers[attempt - 1];
    }

    public void setNumber(int number) {
        if (number <= 0 || number > GuessNumber.MAX) {
            throw new RuntimeException("Число выходит из полуинтервале (0, 100]! Попробуй еще раз!");
        }
        numbers[attempt++] = number;
    }

    public int getAttempt() {
        return attempt;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score++;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, attempt);
    }

    public void  clear() {
        Arrays.fill(numbers, 0, attempt, 0);
        attempt = 0;
    }

    @Override
    public String toString() {
        return name;
    }
}