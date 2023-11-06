package com.startjava.lesson_2_3_4.array;

public class ArraysTheme {
    public static void main(String[] args) {
        reverse();
        multiply();
        deleteElements();
        displayAlphabetLadder();
        fillUniqueNums();
    }

    public static void reverse() {
        System.out.println("1. Реверс значений массива");

        int[] reverseNums = {1, 7, 4, 5, 2, 6, 3};
        int length = reverseNums.length;

        System.out.print("   До реверса: ");
        display(reverseNums);

        for (int i = 0; i < length; i++) {
            int tmp = reverseNums[i];
            reverseNums[i] = reverseNums[--length];
            reverseNums[length] = tmp;
        }

        System.out.print("После реверса: ");
        display(reverseNums);
    }

    private static void display(int[] reverseNums) {
        int length = reverseNums.length;
        System.out.print("[");
        for (int i = 0; i < length - 1; i++) {
            System.out.print(reverseNums[i] + ", ");
        }
        System.out.print(reverseNums[length - 1] +  "]\n");
    }

    public static void multiply() {
        System.out.println("\n2. Произведение элементов массива");

        int[] multipliers = new int[10];
        int length = multipliers.length;
        for (int i = 0; i < length; i++) {
            multipliers[i] = i;
        }

        int result = 1;
        for (int i = 1; i < length - 1; i++) {
            result *= multipliers[i];
            System.out.print(multipliers[i] + (i != length - 2 ? (" * ") : (" = " + result)));
        }
    }

    public static void deleteElements() {
        System.out.println("\n\n3. Удаление элементов массива");

        double[] randomNums = new double[15];
        int length = randomNums.length;
        for (int i = 0; i < length; i++) {
            randomNums[i] = Math.random();
        }

        System.out.println("Исходный массив:");
        display(randomNums);

        double middle = randomNums[length / 2];
        int numberZeroedCells = 0;
        for (int i = 0; i < length; i++) {
            if (randomNums[i] > middle) {
                randomNums[i] = 0;
                numberZeroedCells++;
            }
        }

        System.out.println("\nИзмененный массив:");
        display(randomNums);

        System.out.println("\nКоличество обнуленных ячеек = " + numberZeroedCells);
    }

    private static void display(double[] nums) {
        int i = 0;
        for (double num : nums) {
            System.out.printf("%.3f ", num);
            i++;
            if (i == 8) {
                System.out.println();
            }
        }
    }

    public static void displayAlphabetLadder() {
        System.out.println("\n4.Вывод алфавита лесенкой");

        char[] alphabet = new char[26];
        int length = alphabet.length;

        for (int i = 0; i < length; i++) {
            alphabet[i] = (char) ('A' + i);
        }

        for (int i =  length - 2; i >= -1; --i) {
            for (int j = length - 1; j > i; --j) {
                System.out.print(alphabet[j]);
            }
            System.out.println();
        }
    }

    public static void fillUniqueNums() {
        System.out.println("\n5.Заполнение массива уникальными числами");

        int uniqueNum;
        int[] uniqueNums = new int[30];
        int length = uniqueNums.length;

        for (int i = 0; i < length; i++) {
            uniqueNum = (int) (Math.random() * 40 + 60);
            int index = 0;
            while (index < i) {
                if (uniqueNum == uniqueNums[index]) {
                    uniqueNum = (int) (Math.random() * 40 + 60);
                    index = -1;
                }
                index++;
            }
            uniqueNums[i] = uniqueNum;
        }

        sortBubble(uniqueNums);

        for (int i = 0; i < length; i++) {
            System.out.print(uniqueNums[i] + " ");
            if ((i - 9) % 10 == 0) {
                System.out.println();
            }
        }
    }

    private static int[] sortBubble(int[] array) {
        for (int i =  array.length -1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temporary = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temporary;
                }
            }
        }
        return array;
    }
}
