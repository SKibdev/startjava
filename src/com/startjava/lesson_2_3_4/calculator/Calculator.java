package com.startjava.lesson_2_3_4.calculator;

import java.lang.Math;

public class Calculator {

    private int num1;
    private int num2;
    private char sign;

    public double calculate(String mathExpression) {
        parse(mathExpression);
        return switch (sign) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> (double) num1 / num2;
            case '%' -> num1 % num2;
            case '^' -> Math.pow(num1, num2);
            default -> {
                System.out.println("Ошибка: знак " + sign + " не поддерживается");
                yield Double.MIN_VALUE;
            }
        };
    }

    private void parse(String mathExpression) {
        String[] elements = mathExpression.split(" ");
        sign = elements[1].charAt(0);
        num1 = Integer.parseInt(elements[0]);
        num2 = Integer.parseInt(elements[2]);
    }
}