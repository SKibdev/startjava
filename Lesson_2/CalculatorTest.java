import java.util.Scanner;

public  class CalculatorTest {
    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int num1 = 0;
        char sign;
        int num2 = 0;
        Calculator calculatorOne = new Calculator();
        String answer = "";

        do {
            System.out.println("Введите первое число: ");
            num1 = input.nextInt();
            System.out.println("Введите знак математической операции (+, -, *, /, ^, %): ");
            sign = input.next().charAt(0);
            System.out.println("Введите второе число: ");
            num2 = input.nextInt();
            calculatorOne.setNum1(num1);
            calculatorOne.setSign(sign);
            calculatorOne.setNum2(num2);
            // Проблема в input.nextInt() методе; он читает только значение int. Поэтому, 
            // когда вы продолжите чтение, input.nextLine()вы получите клавишу Enter «\n». 
            // Поэтому, чтобы пропустить это, вам нужно добавить input.nextLine()
            input.nextLine();
            calculatorOne.calculate();
            do {
                System.out.println("Хотите продолжить вычисления? [yes/no]: ");
                answer = input.nextLine();
            } while (!answer.equals("yes") && !answer.equals("no"));
        } while (!answer.equals("no"));
        input.close();
    }
}