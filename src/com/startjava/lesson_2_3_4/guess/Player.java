package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private final String name;
    private final int[] numbers = new int[GuessNumber.QUANTITY_ROUNDS];
    private int attempt;

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
        if (number <= 0 || number > 100) {
            throw new RuntimeException("Ошибка! Попробуйте еще раз! " +
                    "Вводите целые числа в полуинтервале (0, 100]!");
        }
        numbers[attempt++] = number;
    }

    public int getAttempt() {
        return attempt;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, attempt);
    }

    public void  clearNumbers() {
        Arrays.fill(numbers, 0, attempt, 0);
    }

    @Override
    public String toString() {
        return name;
    }
}