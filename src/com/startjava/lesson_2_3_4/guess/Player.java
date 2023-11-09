package com.startjava.lesson_2_3_4.guess;

public class Player {

    private final String name;
    private int[] numbers = new int[10];
    private int index = -1;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addNumber(int number) {
        index++;
        numbers[index] = number;
    }

    public int getNumber() {
        return numbers[index];
    }

    public int[] getNumbers() {
        return numbers;
    }

    public int getIndex() {
        return index;
    }
}