package com.startjava.lesson_2_3_4.array;

import java.lang.reflect.Method;
import java.util.Arrays;

//import org.openjdk.jol.info.ClassLayout;
public class ArrayMain {
//    public static void main(String[] args) throws Exception {
//        System.out.println(ClassLayout.parseInstance(new int[10]).toPrintable());
//    }
    public static void main(String[] args) {
        int[] nums = {1,0,0,0,2,4,5,6,7,8};
        System.out.println(maxSpan1(nums));
        System.out.println(maxSpan(nums));
        System.out.println(maxSpan2(nums));


    }

    public static int maxSpan2(int[] nums) {
        int span = 0;
        int tmp = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    tmp = j-i+1;
                    span = Math.max(tmp,span);
                }
            }
        }
        return span;
    }


    public static int maxSpan1(int[] nums) {
        if(nums.length > 0 && nums[0] != nums[nums.length-1]) {
            return nums.length-1;
        }
        return nums.length;
    }

    public static int maxSpan(int[] nums) {
        int[] flags = new int[nums.length];
        int[] res = new int[nums.length];
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        } else {
            int[] copyNums = new int[nums.length];

            for (int i = 0; i <= nums.length -1; i++) {
                copyNums[i] = nums[i];
            }

            int[] searchNums = new int[nums.length];
            Arrays.sort(copyNums);


                for (int i = 0, j = 0; i < copyNums.length - 1; i++) {
                    if (copyNums[i] == copyNums[i + 1]) {
                        searchNums[j] = copyNums[i];
                    } else {
                        j++;
                    }
                }
            Arrays.sort(searchNums);
            int index = 0;

            for (int i = searchNums.length - 1; searchNums[i] != 0; i--) {
                for (int j = 0; j <= nums.length - 1; j++) {
                    if (searchNums[i] == nums[j]) {
                        flags[index] = j + 1;
                        index++;
                    }
                }
                index = 0;
                Arrays.sort(flags);
                int n = 0;
                while (flags[n] == 0) {
                    n++;
                }
                res[i] = flags[flags.length - 1] - flags[n] + 1;
                flags[flags.length - 1] = 0;
                flags[n] = 0;
            }
            Arrays.sort(res);

        }
        return res[nums.length - 1] == 0 ? 1 : res[nums.length - 1];
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

