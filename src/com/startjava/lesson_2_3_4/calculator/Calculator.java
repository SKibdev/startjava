package com.startjava.lesson_2_3_4.calculator;

import static java.lang.Math.pow;

public class Calculator {

    private int num1;
    private int num2;
    private char sign;

    public double calculate(String mathExpression) {
        double result = Double.MIN_VALUE;
        if (isMathExpressionCorrectly(mathExpression)) {
            switch (sign) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = (double) num1 / (double) num2;
                case '%' -> result = num1 % num2;
                case '^' -> result *= pow(num1, num2);
            }
            return result;
        }
        return result;
    }

    private boolean isMathExpressionCorrectly(String mathExpression) {
        String[] mathExpressions = mathExpression.split(" ");
        sign = mathExpressions[1].charAt(0);
        boolean isSign = sign == '+' || sign == '-' || sign == '*' || sign == '/' ||
                sign == '^' || sign == '%';
        if (!isSign) {
            System.out.println("Ошибка: знак " + sign + " не поддерживается");
            return false;
        }
        num1 = Integer.parseInt(mathExpressions[0]);
        num2 = Integer.parseInt(mathExpressions[2]);
        return true;
    }
}