package com.startjava.lesson_2_3_4.guess;

public class Player {

    private String name;
    //TO DO new int[10]
    private int[] numbers = new int[3];
    private int index = -1;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return numbers[index];
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void addNumber(int number) {
        index++;
        numbers[index] = number;
    }

    public int getIndex() {
        return index;
    }
}