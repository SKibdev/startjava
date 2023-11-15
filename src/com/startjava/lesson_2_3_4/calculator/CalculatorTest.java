package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public  class CalculatorTest {

    static Scanner console = new Scanner(System.in);
    static Calculator calculator = new Calculator();

    public static void main(String[] args) {
        String answer ="yes";
        System.out.println("\n    Добро пожаловать в программу КАЛЬКУЛЯТОР");

        while (!answer.equals("no")) {
            if (answer.equals("yes")) {
                String mathExpression = enterMathExpression();
                double result = calculator.calculate(mathExpression);
                showResult(mathExpression, result);
            }

            System.out.print("\nХотите продолжить вычисления? [yes/no]: ");
            answer = console.nextLine();
        }

        System.out.println("Калькулятор закрылся!!!");
        console.close();
    }

    private static String enterMathExpression() {
        System.out.print("""
                        \nВозможные математические операции "+, -, *, /, ^, %."\s
                        Введите математическое выражение в формате "А + В":\s""");
        return console.nextLine();
    }

    private static void showResult(String mathExpression, double result) {
        System.out.print(mathExpression + " = ");

        if (result != Double.MIN_VALUE) {
            if ((result == (int) result)) {
                System.out.printf("%.0f", result);
            } else {
                System.out.printf("%.3f", result);
            }
        }
    }

}