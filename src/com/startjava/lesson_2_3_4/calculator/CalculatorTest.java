package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {

    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        String answer = "yes";
        System.out.println("\n    Добро пожаловать в программу КАЛЬКУЛЯТОР");

        while (!answer.equals("no")) {
            if (answer.equals("yes")) {
                String expression = enterExpression();
                try {
                    double result = Calculator.calculate(expression);
                    showResult(expression, result);
                } catch (RuntimeException ex) {
                    System.out.println(ex.getMessage());
                }
            }

            System.out.print("\nХотите продолжить вычисления? [yes/no]: ");
            answer = console.nextLine();
        }

        System.out.println("Калькулятор закрылся!!!");
        console.close();
    }

    private static String enterExpression() {
        System.out.print("""
                \nВозможные математические операции "+, -, *, /, ^, %."
                Операции производятся только над целыми положительными числами
                Введите математическое выражение в формате "А + В":\s""");
        return console.nextLine();
    }

    private static void showResult(String expression, double result) {
        System.out.print(expression + " = ");
        System.out.printf((result == (int) result) ? "%.0f" : "%.3f", result);
    }
}