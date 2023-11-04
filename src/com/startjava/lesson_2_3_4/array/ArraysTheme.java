package com.startjava.lesson_2_3_4.array;

public class ArraysTheme {
    public static void main(String[] args) {
        reverse();
        multiplicate();
        deleteElements();
        displayAlphabetLadder();
        fillUniqueNumbers();
    }

    public static void reverse() {
        System.out.println("1. Реверс значений массива");

        int[] reverseNums = {1, 7, 4, 5, 2, 6, 3};
        int length = reverseNums.length;

        System.out.print("   До реверса: ");
        display(reverseNums);

        for (int i = 0; i < length; i++) {
            int tmp = reverseNums[i];
            reverseNums[i] = reverseNums[length - 1];
            reverseNums[length - 1] = tmp;
            length--;
        }

        System.out.print("После реверса: ");
        display(reverseNums);
    }

    private static void display(int[] numbers) {
        int length = numbers.length;
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            System.out.print(numbers[i] + ", ");
        }
        System.out.print(numbers[length - 1] +  "]\n");
    }

    public static void multiplicate() {
        System.out.println("\n2. Произведение элементов массива");

        int[] multipliedNums = new int[10];
        int length = multipliedNums.length;
        for (int i = 0; i < length; i++) {
            multipliedNums[i] = i;
        }

        int multiplication = 1;
        for (int i = 1; i < length - 1; i++) {
            multiplication *= multipliedNums[i];
            System.out.print(multipliedNums[i] + (i != length - 2 ? (" * ") : (" = " + multiplication)));
        }
    }

    public static void deleteElements() {
        System.out.println("\n\n3. Удаление элементов массива");

        double[] numbers2 = new double[15];
        int length = numbers2.length;
        for (int i = 0; i < length; i++) {
            numbers2[i] = Math.random();
        }

        System.out.println("Исходный массив:");
        displayNumbers2(numbers2);

        double middle = numbers2[length/2];
        int counter = 0;
        for (int i = 0; i < length; i++) {
            if (numbers2[i] > middle) {
                numbers2[i] = 0;
                counter++;
            }
        }

        System.out.println("\nИзмененный массив:");
        displayNumbers2(numbers2);

        System.out.println("\nКоличество обнуленных ячеек = " + counter);
    }

    private static void displayNumbers2(double[] numbers2) {
        int i = 0;
        for (double number : numbers2) {
            if (i == 7) {
                System.out.printf("%.3f \n", number);
            } else {
                System.out.printf("%.3f ", number);
            }
            i++;
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

    public static void fillUniqueNumbers() {
        System.out.println("\n5.Заполнение массива уникальными числами");

        int[] numbers3 = new int[30];
        int length = numbers3.length;

        for (int i = 0; i < length; i++) {
            numbers3[i] = (int) (Math.random() * 40 + 60);
            int index = 0;
            while (index < i) {
                if (numbers3[i] == numbers3[index]) {
                    numbers3[i] = (int) (Math.random() * 40 + 60);
                    index = -1;
                }
                index++;
            }
        }

        sortBubble(numbers3);

        for (int i = 0; i < length; i++) {
            System.out.print(numbers3[i] + " ");
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
