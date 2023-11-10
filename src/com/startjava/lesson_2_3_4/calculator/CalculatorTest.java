package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public  class CalculatorTest {

    static String mathExpression;
    static Scanner console = new Scanner(System.in);
    static Calculator calculator = new Calculator();
    static String answer;


    public static void main(String[] args) {
        do {
            System.out.print("""

                        Добро пожаловать в программу КАЛЬКУЛЯТОР\s
                    возможные математические операции "+, -, *, /, ^, %"\s

                    Введите математическое выражение в формате "А + В":\s""");
            mathExpression = console.nextLine();

            showResult();
        } while (isNext());
        console.close();
    }

    private static void showResult() {
        System.out.print(mathExpression + " = ");
        double result = calculator.calculate(mathExpression);
        if (result != Double.MIN_VALUE) {
            if ((result == (int) result)) {
                System.out.printf("%.0f", result);
            } else {
                System.out.printf("%.3f", result);
            }
        }
    }

    private static boolean isNext() {
        System.out.print("\nХотите продолжить вычисления? [yes/no]: ");
        answer = console.nextLine();
        if (!answer.equals("yes") && !answer.equals("no")) {
            isNext();
        }
        return (answer.equals("yes"));
    }
}