package com.startjava.lesson1.base;

public class IfElseStatementTheme {

    public static void main(String[] args) {
        System.out.println("1. Перевод псевдокода на язык Java");
        boolean maleSex = true;

        if(!maleSex) {
            System.out.println("This is a woman");
        } else {
            System.out.println("This is a man");
        }

        int age = 35;
        if (age > 18) {
            System.out.println("adult");
        } else {
            System.out.println("minor");
        }

        double humanHeight = 1.9;
        if (humanHeight < 1.8) {
            System.out.println("average height");
        } else {
            System.out.println("tall");
        }

        char firstLetterName = "Ivan".charAt(0);
        if (firstLetterName == 'M') {
            System.out.println("this person wins $10");
        } else if (firstLetterName == 'I') {
            System.out.println("this person wins $5");
        } else {
            System.out.println("this person wins nothing");
        }

        System.out.println("\n2. Поиск большего числа");
        int num1 = 65;
        int num2 = 75;

        if (num1 > num2) {
            System.out.println(num1 + " > " + num2);
        } else if (num1 < num2) {
            System.out.println(num1 + " < " + num2);
        } else {
            System.out.println(num1 + " = " + num2);
        }

        System.out.println("\n3. Проверка числа");
        int num = 256;

        if (num == 0) {
            System.out.println("Заданное число является 0");
        } else {
            if (num > 0) {
                System.out.print("Число " + num + " является положительным");
            } else { 
                System.out.print("Число " + num + " является отрицательным");
            }
            if (num % 2 == 0) {
                System.out.println(" четным");
            } else {
                System.out.println(" нечетным");
            }
        }

        System.out.println("\n4. Поиск одинаковых цифр в числах");
        int num3 = 123;
        int num4 = 223;
        int onesNum3 = num3 % 100 % 10;
        int tensNum3 = num3 % 100 / 10;
        int hundredsNum3 = num3 / 100;
        boolean isEqualOnes = onesNum3 - num4 % 100 % 10 == 0;
        boolean isEqualTens = tensNum3 - num4 % 100 / 10 == 0;
        boolean isEqualHundreds = hundredsNum3 - num4 / 100 == 0;
        
        if (isEqualOnes || isEqualTens || isEqualHundreds) {
            System.out.println("Исходные числа " + num3 + " и " + num4);
            if (isEqualOnes) {
                System.out.println("Цифра " + onesNum3 + 
                        " находится в ПЕРВОМ разряде обоих чисел");
            }
            if (isEqualTens) {
                System.out.println("Цифра " + tensNum3 + 
                        " находится во ВТОРОМ разряде обоих чисел");
            }
            if (isEqualHundreds) {
                System.out.println("Цифра " + hundredsNum3 + 
                        " находится в ТРЕТЬЕМ разряде обоих чисел");
            }
        } else {
            System.out.println("Равных цифр нет");
        }

        System.out.println("\n5. Определение символа по его коду");
        char symbol = '\u0057';
        if (symbol >= '0' && symbol <= '9') {
            System.out.println("Символ " + symbol + " является цифрой");
        } else if (symbol >= 'A' && symbol <= 'Z') {
            System.out.println("Символ " + symbol + " является большой буквой");
        } else if (symbol >= 'a' && symbol <= 'z') {
            System.out.println("Символ " + symbol + " является маленькой буквой");
        } else {
            System.out.println("Символ " + symbol + " - не буква и не цифра");
        }

        System.out.println("\n6. Подсчет суммы вклада и начисленных банком %");
        double deposit = 301000;
        double percent = 10;

        if (deposit < 100000) {
            percent = 5;
        } else if (deposit <= 300000) {
            percent = 7;
        }

        System.out.println("Сумма вклада = " + deposit + 
                "\nСумма начисленного % = " + deposit * percent / 100 + 
                "\nИтоговая сумма с % = " + (deposit + deposit * percent / 100));

        System.out.println("\n7. Определение оценки по предметам");
        int percentHistory = 59;
        int gradeHistory = 2;

        if (percentHistory > 60 && percentHistory <= 73) {
            gradeHistory = 3;
        } else if (percentHistory > 73 && percentHistory <= 91) {
            gradeHistory = 4;
        } else if (percentHistory > 91) {
            gradeHistory = 5;
        }

        int percentProgramming = 92;
        int gradeProgramming = 2;

        if (percentProgramming > 60 && percentProgramming <= 73) {
            gradeProgramming = 3;
        } else if (percentProgramming > 73 && percentProgramming <= 91) {
            gradeProgramming = 4;
        } else if (percentProgramming > 91) {
            gradeProgramming = 5;
        }  

        System.out.println("История " + gradeHistory + "\nПрограммирование " + gradeProgramming + 
                    "\nСредний балл оценок по предметам " + (gradeHistory + gradeProgramming) / 2 + 
                    "\nСредний % по предметам " + (percentHistory + percentProgramming) / 2);

        System.out.println("\n8. Расчет годовой прибыли");
        int monthTakings = 13000;
        int monthRent = 5000;
        int monthCostPrice = 9000;
        int yearProfit = (monthTakings - (monthRent + monthCostPrice)) * 12;
        if (yearProfit > 0) {
            System.out.println("Прибыль за год: +" + yearProfit);
        } else {
            System.out.println("Прибыль за год: " + yearProfit);
        }
    }
}