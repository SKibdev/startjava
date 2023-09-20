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
        int num = -257;
        boolean isEvenNumber = num % 2 == 0;

        if (num == 0) {
            System.out.println("Заданное число является 0");
        } else {
            if (num > 0) {
                System.out.print("Число " + num + " является положительным");
            } else { 
                System.out.print("Число " + num + " является отрицательным");
            }
            if (isEvenNumber) {
                System.out.println(" четным");
            } else {
                System.out.println(" нечетным");
            }
        }

        System.out.println("\n4. Поиск одинаковых цифр в числах");
        int num3 = 123;
        int num4 = 223;
        boolean sameFirstDigit = num3 % 100 % 10 - num4 % 100 % 10 == 0;
        boolean sameSecondDigit = num3 % 100 / 10 - num4 % 100 / 10 == 0;
        boolean sameThirdDigit = num3 / 100 - num4 / 100 == 0;
        
        if (sameFirstDigit || sameSecondDigit || sameThirdDigit) {
            System.out.println("Исходные числа " + num3 + " и " + num4);
            if (sameFirstDigit) {
                System.out.println("Цифра " + num3 % 100 % 10 + 
                        " находится в ПЕРВОМ разряде обоих чисел");
            }
            if (sameSecondDigit) {
                System.out.println("Цифра " + num3 % 100 / 10 + 
                        " находится во ВТОРОМ разряде обоих чисел");
            }
            if (sameThirdDigit) {
                System.out.println("Цифра " + num3 / 100 + 
                        " находится в ТРЕТЬЕМ разряде обоих чисел");
            }
        } else {
            System.out.println("Равных цифр нет");
        }

        System.out.println("\n5. Определение символа по его коду");
        char symbol = '\u0057';
        if (48 <= (int) symbol & (int) symbol <= 57) {
            System.out.println("Символ " + symbol + " является цифрой");
        } else if (65 <= (int) symbol & (int) symbol <= 90) {
            System.out.println("Символ " + symbol + " является большой буквой");
        } else if (97 <= (int) symbol & (int) symbol <= 122) {
            System.out.println("Символ " + symbol + " является маленькой буквой");
        } else {
            System.out.println("Символ " + symbol + " - не буква и не цифра");
        }

        System.out.println("\n6. Подсчет суммы вклада и начисленных банком %");
        double depositAmount = 301_000;
        double depositInterest = 0;
        if (0 < depositAmount & depositAmount < 100_000) {
            depositInterest = 5;
        } else if (100_000 <= depositAmount & depositAmount <= 300_000) {
            depositInterest = 7;
        } else if (depositAmount > 300_000) {
            depositInterest = 10;
        } else {
            System.out.println("Сумма вклада введена некорректно");
        }
        System.out.println("Сумма вклада = " + depositAmount + 
                "\nСумма начисленного % = " + depositAmount * depositInterest / 100 + 
                "\nИтоговая сумма с % = " + depositAmount * (100 + depositInterest) / 100);

        System.out.println("\n7. Определение оценки по предметам");
        int percentHistory = 59;
        int percentProgramming = 92;
        int gradeHistory = 0;
        int gradeProgramming = 0;

        if (0 < percentHistory & percentHistory <= 60) {
            gradeHistory = 2;
        } else if (60 < percentHistory & percentHistory <= 73) {
            gradeHistory = 3;
        } else if (73 < percentHistory & percentHistory <= 91) {
            gradeHistory = 4;
        } else if (91 < percentHistory) {
            gradeHistory = 5;
        } else {
            System.out.println("Результаты теста по истории введены некорректно");
        }

        if (0 < percentProgramming & percentProgramming <= 60) {
            gradeProgramming = 2;
        } else if (60 < percentProgramming & percentProgramming <= 73) {
            gradeProgramming = 3;
        } else if (73 < percentProgramming & percentProgramming <= 91) {
            gradeProgramming = 4;
        } else if (91 < percentProgramming) {
            gradeProgramming = 5;
        } else {
            System.out.println("Результаты теста по программированию введены некорректно");
        }

        System.out.println("История " + gradeHistory + "\nПрограммирование " + gradeProgramming + 
                    "\nСредний балл оценок по предметам " + (gradeHistory + gradeProgramming) / 2 + 
                    "\nСредний % по предметам " + (percentHistory + percentProgramming) / 2);

        System.out.println("\n8. Расчет годовой прибыли");
        int monthTakings = 13000;
        int monthRent = 5000;
        int monthCostPrice = 9000;
        int yearProfit = (monthTakings - (monthRent + monthCostPrice))*12;
        if (yearProfit > 0) {
            System.out.println("Прибыль за год: +" + yearProfit);
        } else {
            System.out.println("Прибыль за год: " + yearProfit);
        }
    }
}