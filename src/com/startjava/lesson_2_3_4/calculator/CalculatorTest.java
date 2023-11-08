package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public  class CalculatorTest {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Calculator calculator = new Calculator();

        do {
            System.out.print ("""

                        Добро пожаловать в программу КАЛЬКУЛЯТОР\s
                    возможные математические операции "+, -, *, /, ^, %"\s

                    Введите математическое выражение в формате "А + В":\s""");

            String mathExpression = console.nextLine();

            System.out.print(mathExpression + " = ");
            double result = calculator.calculate(mathExpression);
            if (result != Double.MIN_VALUE) {
                if ((result == (long) result)) {
                    System.out.printf("%.0f", result);
                } else {
                    System.out.printf("%.3f",  result);
                }
            }
        } while (isContinueCalculations());
        console.close();
    }

    private static boolean isContinueCalculations() {
        Scanner console = new Scanner(System.in);
        System.out.print("\nХотите продолжить вычисления? [yes/no]: ");
        String answer = console.nextLine();
        if (!answer.equals("yes") && !answer.equals("no")) {
            isContinueCalculations();
        }
        return (answer.equals("yes"));
    }
}