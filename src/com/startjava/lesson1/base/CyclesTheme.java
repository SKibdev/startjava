package com.startjava.lesson1.base;

public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("1. Подсчет суммы четных и нечетных чисел");
        int firstEvenNum = -10;
        int firstOddNum = -9;
        int sumEvenNums = 0;
        int sumOddNums = 0;

        do {
            sumOddNums += firstOddNum;
            sumEvenNums += firstEvenNum;
            firstEvenNum += 2;
            firstOddNum += 2;
        } while (firstOddNum <= 21);

        System.out.println("В отрезке [-10, 21] сумма четных чисел = " + sumEvenNums + 
                ", а нечетных = " + sumOddNums);

        System.out.println("\n2. Вывод чисел в порядке убывания");
        int num1 = 10;
        int num2 = 5;
        int num3 = -1;
        int min = num1;
        int max = num2;

        if (num2 < min) {
            min = num1;
        }
        if (num3 < min) { 
            min = num3;
        }
        if (num1 > max) {
            max = num1;
        } 
        if (num3 > max) {
            max = num3;
        }

        for (int i = max - 1; i > min; i--) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр");
        int num = 1234;
        int sumDigits = 0;

        while (num > 0) {
            int digit = num % 10;
            System.out.print(digit);
            sumDigits += digit;
            num /= 10;
        }

        System.out.println("\nСумма цифр числа = " + sumDigits);

        System.out.println("\n\n4. Вывод чисел в несколько строк");
        int startInterval = 1;
        int endInterval = 24;

        for (; startInterval < endInterval;) {
            for (int i = 1; i <= 5; i++) {
                if (startInterval > endInterval) {
                    System.out.printf("%4d", 0);
                } else {
                    System.out.printf("%4d", startInterval);
                }
                startInterval += 2;
            }
            System.out.println();
        }

        System.out.println("\n5. Проверка количества двоек числа на четность/нечетность");
        int checkNum = 3242592;
        System.out.print("В " + checkNum);
        int countTwos = 0;

        while (checkNum > 0) {
            if (checkNum % 10 == 2) {
                countTwos++;
            }
            checkNum /= 10;
        }

        if (countTwos % 2 == 0) {
            System.out.println(" (четное) количество двоек -  " + countTwos);
        } else {
            System.out.println(" (нечетное) количество двоек - " + countTwos);
        }

        System.out.println("\n6. Отображение геометрических фигур");
        for (int i = 0; i < 5; i++) {
            System.out.println("**********");
        }

        System.out.println();
        int countStrings = 0;
        int lengthString = 0;
        int maxSize = 5;

        while (countStrings < 5) {
            while (lengthString < maxSize) {
                System.out.print("#");
                lengthString++;
            }
            System.out.println();
            maxSize--;
            lengthString = 0;
            countStrings++;
        }

        System.out.println();
        countStrings = 0;
        lengthString = 0;
        maxSize = 1;
        int minimization = 2;

        do {
            do {
                System.out.print("$");
                lengthString++;
            } while (lengthString < maxSize);
            lengthString = 0;
            if (maxSize > minimization) {
                minimization--;
                maxSize--;
            } else {
                maxSize++;
            }
            System.out.println();
            countStrings++;
        } while (countStrings < 5);

        System.out.println("\n7. Отображение ASCII-символов");
        char lastSymbol = '/';
        System.out.printf("%-8s%-10s%-27s%n", "DECIMAL", "CHARACTER", "DESCRIPTION");

        for (int i = 15; i <= lastSymbol; i += 2) {
            System.out.printf("  %-10s%-11s%s%n", i, (char) i, Character.getName(i));
            if (i == '/') {
                i = '_';
                lastSymbol = 'z';
            }
        }

        System.out.println("\n8. Проверка, является ли число палиндромом");
        int testNum = 1234321;
        int copyTestNum = testNum;
        int reverseNum = 0;

        while (copyTestNum > 0) {
            reverseNum *= 10;
            int digit = copyTestNum % 10;
            copyTestNum /= 10;
            reverseNum += digit;
        }

        if (testNum == reverseNum) {
            System.out.println("число " + reverseNum + " является палиндромом");
        } else {
            System.out.println("число " + reverseNum + " не является палиндромом");
        }

        System.out.println("\n9. Проверка, является ли число счастливым");
        int luckyNum = 653653;
        int leftHalf = luckyNum / 1000;
        int rightHalf = luckyNum % 1000;
        int sumLeftHalf = 0;
        int sumRightHalf = 0;

        for (int i = 0; i < 3; i++) {
            sumLeftHalf += leftHalf % 10;
            leftHalf /= 10;
            sumRightHalf += rightHalf % 10;
            rightHalf /= 10;
        }
        
        if (sumLeftHalf == sumRightHalf) {
            System.out.println("Число " + luckyNum + " является счастливым \n" + 
                    "Сумма цифр ABC = " + sumLeftHalf + ", а сумма DEF = " + sumRightHalf);
        } else {
            System.out.println("Число " + luckyNum + " не является счастливым \n" + 
                    "Сумма цифр ABC = " + sumLeftHalf + ", а сумма DEF = " + sumRightHalf);
        }

        System.out.println("\n10. Отображение таблицы умножения Пифагора");

        for (int i = 1; i <= 9; i++) {
            if (i == 1) {
                System.out.printf("%n   |");
                for (int j = 2; j <= 9; j++) {
                    System.out.printf("%3s", (i*j));
                }
                System.out.printf("%n%2s", "----------------------------");
            } else {
                System.out.printf( "%n%2s |", i);
                for (int j = 2; j <= 9; j++) {
                    System.out.printf("%3s", (i*j));
                }
            }
        }
    }
}