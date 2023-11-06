package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public  class CalculatorTest {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Calculator calculatorOne = new Calculator();
        String answer;

        do {
            System.out.print ("Добро пожаловать в программу КАЛЬКУЛЯТОР \n" +
                    "возможные математические операции \"+, -, *, /, ^, %\" \n\n" +
                    "Введите математическое выражение в формате \"А + В\": ");

            String[] mathExpression = (console.nextLine().split(" "));
            calculatorOne.setMathExpression(mathExpression);

            // Проблема в console.nextInt() методе; он читает только значение int. Поэтому,
            // когда вы продолжите чтение, console.nextLine()вы получите клавишу Enter «\n». 
            // Поэтому, чтобы пропустить это, вам нужно добавить console.nextLine()
         //   console.nextLine();
            
            calculatorOne.calculate();
            do {
                System.out.println("Хотите продолжить вычисления? [yes/no]: ");
                answer = console.nextLine();
            } while (!answer.equals("yes") && !answer.equals("no"));
        } while (answer.equals("yes"));
        console.close();
    }
}