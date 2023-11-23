package com.startjava.lesson_2_3_4.calculator;

import java.lang.Math;

public class Calculator {

    private static final int EXPRESSION_LENGTH = 3;
    private static int num1;
    private static int num2;
    private static char sign;

    public static double calculate(String expression) {
        parse(expression);
        return switch (sign) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> (double) num1 / num2;
            case '%' -> num1 % num2;
            case '^' -> Math.pow(num1, num2);
            default -> throw new RuntimeException("Ошибка: знак " + sign + " не поддерживается");
        };
    }

    private static void parse(String expression) {
        String[] elements = expression.split(" ");
        if (elements.length != EXPRESSION_LENGTH) {
            throw new RuntimeException("Ошибка!!! Мат. выражение не в формате \"А + В\"");
        }
        sign = elements[1].charAt(0);
        try {
            num1 = Integer.parseInt(elements[0]);
            num2 = Integer.parseInt(elements[2]);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException("Ошибка!!! Операции возможны только над целыми числами!");
        }
        if (num1 <= 0 || num2 <= 0) {
            throw new RuntimeException("Ошибка!!! Числа должны быть положительными!");
        }
    }
}