public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("1. Подсчет суммы четных и нечетных чисел");
        int numEven = -10;
        int numOdd = -9;
        int sumEven = 0;
        int sumOdd = 0;

        do {
            sumOdd += numOdd;
            sumEven += numEven;
            numEven += 2;
            numOdd += 2; 
        } while (numOdd <= 21);

        System.out.println("В отрезке [-10, 21] сумма четных чисел = " + sumEven + 
                ", а нечетных = " + sumOdd);

        System.out.println("\n2. Вывод чисел в порядке убывания");
        int num1 = 10;
        int num2 = 5;
        int num3 = -1;
        int numMax = 0;
        
        if ((num1 > num2) && (num1 > num3)) {
            numMax = num1;
        } else {
            if (num2 > num3) {
                numMax = num2;
            } else {
                numMax = num3;
            }
        }

        int numMin = 0;
        
        if ((num1 < num2) && (num1 < num3)) {
            numMin = num1;
        } else {
            if (num2 < num3) {
                numMin = num2;
            } else {
                numMin = num3;
            }
        }

        for (int i = numMax - 1; i > numMin; i--) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр");
        int num = 1234;
        int digit = num % 10;
        int sumDigit = 0;

        while (num > 0) {
            System.out.print(digit);
            sumDigit += digit;
            num = num / 10;
            digit = num % 10;
        }

        System.out.println("\nСумма цифр числа = " + sumDigit);

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
        int number = 3242592;
        System.out.print("В " + number);
        int twosСounter = 0;

        while (number > 0) {
            if (number % 10 == 2) {
                twosСounter++;
            }
            number = number / 10;
        }

        if (twosСounter % 2 == 0) {
            System.out.println(" (четное) количество двоек -  " + twosСounter);
        } else {
            System.out.println(" (нечетное) количество двоек - " + twosСounter);
        }

        System.out.println("\n6. Отображение геометрических фигур");
        for (int i = 0; i < 5; i++) {
            System.out.println("**********");
        }

        System.out.println();
        int triangleSide1 = 0;
        int triangleSide2 = 0;
        int maxSize = 5;

        while (triangleSide1 < 5) {
            while (triangleSide2 < maxSize) {
                System.out.print("#");
                triangleSide2++;
            }
            System.out.println();
            maxSize--;
            triangleSide2 = 0;
            triangleSide1++;
        }

        System.out.println();
        triangleSide1 = 0;
        triangleSide2 = 0;
        maxSize = 1;
        int minimization = 2;

        do {
            do {
                System.out.print("$");
                triangleSide1++;
            } while (triangleSide1 < maxSize);
            triangleSide1 = 0;
            if (maxSize > minimization) {
                minimization--;
                maxSize--;
            } else {
                maxSize++;
            }
            System.out.println();
            triangleSide2++;
        } while (triangleSide2 < 5);

        System.out.println("\n7. Отображение ASCII-символов");
        int decimal = 15;
        char character = 15;
        char lastSymbol = '/';
        System.out.printf("%-8s%-10s%-27s%n", "DECIMAL", "CHARACTER", "DESCRIPTION");

        for (int i = 15; i <= lastSymbol; i += 2) {
            System.out.printf("  %-10s%-11s%s%n", decimal, character, Character.getName(i));
            decimal += 2;
            character += 2;
            if (i == '/') {
                i = '_';
                character = 'a';
                decimal = 'a';
                lastSymbol = 'z';
            }
        }

        System.out.println("\n8. Проверка, является ли число палиндромом");
        int numTest = 1234321;
        int numTmp = numTest;
        int digitNum = 0;
        int numberInverted = 0;

        while (numTmp > 10) {
            digitNum = numTmp % 10;
            numTmp = numTmp / 10;
            numberInverted = (numberInverted + digitNum) * 10;
        }

        numberInverted += numTmp;

        if (numTest == numberInverted) {
            System.out.println("число " + numTest + " является палиндромом");
        } else {
            System.out.println("число " + numTest + " не является палиндромом");
        }

        System.out.println("\n9. Проверка, является ли число счастливым");
        int numberTest = 653653;
        int numberTest1 = numberTest / 1000;
        int numberTest2 = numberTest % 1000;
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < 3; i++) {
            sum1 += numberTest1 % 10;
            numberTest1 = numberTest1 / 10;
            sum2 += numberTest2 % 10;
            numberTest2 = numberTest2 / 10;
        }
        
        if (sum1 == sum2) {
            System.out.println("Число " + numberTest + " является счастливым \n" + 
                    "Сумма цифр ABC = " + sum1 + ", а сумма DEF = " + sum2);
        } else {
            System.out.println("Число " + numberTest + " не является счастливым \n" + 
                    "Сумма цифр ABC = " + sum1 + ", а сумма DEF = " + sum2);
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