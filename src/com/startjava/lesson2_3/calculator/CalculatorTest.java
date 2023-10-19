package com.startjava.lesson2_3.calculator;

import java.util.Scanner;

public  class CalculatorTest {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Calculator calculatorOne = new Calculator();
        String answer;

        do {
            System.out.println("Введите первое число: ");
            int num1 = console.nextInt();
            calculatorOne.setNum1(num1);

            System.out.println("Введите знак математической операции (+, -, *, /, ^, %): ");
            char sign = console.next().charAt(0);
            calculatorOne.setSign(sign);

            System.out.println("Введите второе число: ");
            int num2 = console.nextInt();
            calculatorOne.setNum2(num2);

            // Проблема в console.nextInt() методе; он читает только значение int. Поэтому, 
            // когда вы продолжите чтение, console.nextLine()вы получите клавишу Enter «\n». 
            // Поэтому, чтобы пропустить это, вам нужно добавить console.nextLine()
            console.nextLine();
            
            calculatorOne.calculate();
            do {
                System.out.println("Хотите продолжить вычисления? [yes/no]: ");
                answer = console.nextLine();
            } while (!answer.equals("yes") && !answer.equals("no"));
        } while (!answer.equals("no"));
        console.close();
    }
}