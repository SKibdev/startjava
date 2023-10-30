package com.startjava.lesson_2_3_4.array;

import java.lang.reflect.Method;
//import org.openjdk.jol.info.ClassLayout;
public class ArrayMain {
//    public static void main(String[] args) throws Exception {
//        System.out.println(ClassLayout.parseInstance(new int[10]).toPrintable());
//    }
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6};

        for (int elementArray : array ) {
            System.out.print(elementArray);
        }
        System.out.println("\n" + linearSearch(array, 7));
        System.out.println(binarySearch(array, 7));
    }
    public static int linearSearch(int[] source, int k) {
        for (int i = 0; i < source.length; i++) {
            if (source[i] == k) {
                return i;
            }
        }
        return -1;
    }
    public static int binarySearch(int[] source, int key) {
        int low = 0;
        int high = source.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (key < source[middle]) {
                high = middle -1;
            } else if (key > source[middle]) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

}



//    public static void main(String[] args) {
//
//        Object obj = new int[]{3, 6, 9};
//        int[] array = (int[]) obj;
//        System.out.println(obj);
//        System.out.println(array);

//        int[] array = {};
//        System.out.println("Тип массива - " + array.getClass());
//        System.out.println("Суперкласс типа массива - " + array.getClass().getSuperclass());
//
//        System.out.println("Доступные методы:");
//        for (Method m : array.getClass().getMethods()) {
//            System.out.println(m.getName());
//        }


//        int[] numbers = new int[6];
//
//        float[] numbers1 = {5.1f, .5f, 200.5f};
//
//        System.out.println(numbers.length);
//        System.out.println(numbers1.length);
//
//        for (float number1 : numbers1) {
//            System.out.print(number1 + " ");
//        }
//        System.out.println();
//
//        for (int number : numbers) {
//            System.out.print(number + " ");
//        }
//
//        String[] text = new String[3];
//        for (String string : text) {
//            System.out.print(string + " ");
//        }
//        text -> array[addressHello ссылка|addressJava ссылка|addressJava2 ссылка]
//                        "Hello"               "Java"             "Java2"
//    }

