package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public  class CalculatorTest {

    static Scanner console = new Scanner(System.in);
    static Calculator calculator = new Calculator();

    public static void main(String[] args) {
        String answer = "yes";
        while (answer.equals("yes")) {
            System.out.print("""

                        Добро пожаловать в программу КАЛЬКУЛЯТОР\s
                    возможные математические операции "+, -, *, /, ^, %"\s

                    Введите математическое выражение в формате "А + В":\s""");
            String mathExpression = console.nextLine();
            double result = calculator.calculate(mathExpression);

            showResult(mathExpression, result);
            answer = isNext();
        }
        System.out.println("Калькулятор закрылся!!!");
        console.close();
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

    private static String isNext() {
        System.out.print("\nХотите продолжить вычисления? [yes/no]: ");
        String answer = console.nextLine();
        if (!answer.equals("yes") && !answer.equals("no")) {
            answer = isNext();
        }
        return answer;
    }
}