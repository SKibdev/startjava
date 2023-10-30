package com.startjava.lesson_2_3_4.array;

public class ArraysTheme {
    public static void main(String[] args) {
        int length;

        System.out.println("1. Реверс значений массива");
        int[] numbers = {1, 7, 4, 5, 2, 6, 3};
        length = numbers.length;

        System.out.print("   До реверса: ");
        displayNumbers(numbers);

        for (int i = 0, j = length - 1; i < (length - 1)/2; i++, j--) {
            int temporary = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temporary;
        }

        System.out.print("После реверса: ");
        displayNumbers(numbers);

        System.out.println("\n2. Произведение элементов массива");
        int[] numbers1 = new int[10];
        length = numbers1.length;
        int multiplication = 1;

        for (int i = 0; i <= length - 1; i++) {
            numbers1[i] = i;
            if ((i > 0 && i < length - 1)) {
                multiplication *= numbers1[i];
            }
        }

        for (int i = 1; i <= length - 2; i++) {
            System.out.print(i == length - 2 ? (numbers1[i] + " = " + multiplication) : (numbers1[i] + " * "));
        }

        System.out.println("\n\n3. Удаление элементов массива");
        double[] numbers2 = new double[15];
        length = numbers2.length;

        for (int i = 0; i <= length - 1; i++) {
            numbers2[i] = Math.random();
        }

        System.out.println("Исходный массив:");
        displayNumbers2(numbers2);

        double middle = numbers2[length/2];
        int counter = 0;
        for (int i = 0; i <= length - 1; i++) {
            if (numbers2[i] > middle) {
                numbers2[i] = 0;
                counter++;
            }
        }

        System.out.println("\nИзмененный массив:");
        displayNumbers2(numbers2);

        System.out.println("\nКоличество обнуленных ячеек = " + counter);

        System.out.println("\n4.Вывод алфавита лесенкой");
        char[] letters = new char[26];
        length = letters.length;
        int i = 0;
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            letters[i++] = ch;
        }

        for (i = length - 1; i > 0; i--) {
            System.out.print(letters[i]);
        }

        System.out.println("\n5.Заполнение массива уникальными числами");


    }
    private static void displayNumbers (int[] numbers) {
        for (int i = 0; i <= numbers.length-1; i++) {
            if (i == 0) {
                System.out.print("[" + numbers[i] + ",");
            } else if (i == numbers.length-1) {
                System.out.print(numbers[i] + "]\n");
            } else {
                System.out.print(numbers[i] + ",");
            }
        }
     }

    private static void displayNumbers2 (double[] numbers2) {
        for (int i = 0; i <= numbers2.length - 1; i++) {
            if (i == 7) {
                System.out.printf("%.3f \n", numbers2[i]);
            } else {
                System.out.printf("%.3f ", numbers2[i]);
            }
        }
    }

}
