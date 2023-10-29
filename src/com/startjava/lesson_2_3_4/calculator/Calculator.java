package com.startjava.lesson2_3_4.calculator;

public class Calculator {

    private int num1;
    private int num2;
    private char sign;
    private boolean isError;

    public void setNum1(int num1) {
        if (num1 > 0) {
            this.num1 = num1;
        } else {
            System.out.println("Ошибка! Первое число должно быть положительным ");
            isError = true;
        }
    }

    public void setNum2(int num2) {
        if (num2 > 0) {
            this.num2 = num2;
        } else {
            System.out.println("Ошибка! Второе число должно быть положительным ");
            isError = true;
        }
    }

    public void setSign(char sign) {
        boolean isSign = sign == '+' || sign == '-' || sign == '*' || sign == '/' || 
                sign == '^' || sign == '%';
        if (isSign) {
            this.sign = sign;
        } else {
            System.out.println("Ошибка! Введите одну из допустимых операций +, -, *, /, ^, % ");
            isError = true;
        }
    }

    public void calculate() {
        if (!isError) {
            int result = 1;
            switch(sign) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                case '%':
                    result = num1 % num2;
                    break;
                case '^':
                    for (int i = 1; i <= num2; i++) {
                        result *= num1;
                    }
            }
            System.out.println(num1 + " " + sign + " " + num2 + " = " + result);
        } else {
            isError = false;
        }
    }
}