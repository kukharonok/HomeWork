package home.home_work_2.sorts;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortsUtilsMain {

    public static void main(String[] args) {

        int[] test1 = new int[]{4, 45, 66, 2, -6, 0, 13, 77};
        int[] test2 = new int[]{1, 2, 3, 4, 5, 6};
        int[] test3 = new int[]{1, 1, 1, 1};
        int[] test4 = new int[]{9, 1, 5, 99, 9, 9};
        int[] test5 = new int[]{};
        int[] test6 = new int[]{4, 45, 66, 2, -6, 0, 13, 77};
        int[] test7 = new int[]{3, 4, 5, 6, 7, 8};
        int[] test8 = new int[]{2, 2, 2, 2};
        int[] test9 = new int[]{8, 1, 5, 99, 8, 8};

        printArrayBubble(test1);
        printArrayBubble(test2);
        printArrayBubble(test3);
        printArrayBubble(test4);
        printArrayBubble(test5);
        System.out.println("-------------------------------------------------------------");
        printArrayShaker(test6);
        printArrayShaker(test7);
        printArrayShaker(test8);
        printArrayShaker(test9);
        printArrayShaker(test5);
        Random newRandom = new Random();

        int arraySize = newRandom.nextInt(20);
        int[] arr = new int[arraySize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = newRandom.nextInt(100);
        }
        System.out.print("Массив до сортировки:    ");
        System.out.println(Arrays.toString(arr));
        System.out.print("Массив после сортировки: ");
        System.out.println(Arrays.toString(SortsUtils.sortSelection(arr)));

        int[] test = arrayConsole();
        System.out.print("Массив до сортировки:    ");
        System.out.println(Arrays.toString(test));
        System.out.print("Массив после сортировки: ");
        System.out.println(Arrays.toString(SortsUtils.sortInsertion(test)));

    }

    /**
     * Печать в консоль переданного массива до сортировки
     * и после пузырьковой сортировки sortBubble.
     *
     * @param array целочисленный массив.
     */
    public static void printArrayBubble(int[] array) {
        System.out.print("Массив до сортировки Bubble:    ");
        System.out.println(Arrays.toString(array));
        System.out.print("Массив после сортировки Bubble: ");
        System.out.println(Arrays.toString(SortsUtils.sortBubble(array)));
    }

    /**
     * Печать в консоль переданного массива до сортировки
     * и после шейкерной сортировки sortShaker.
     *
     * @param array целочисленный массив.
     */
    public static void printArrayShaker(int[] array) {
        System.out.print("Массив до сортировки Shaker:    ");
        System.out.println(Arrays.toString(array));
        System.out.print("Массив после сортировки Shaker: ");
        System.out.println(Arrays.toString(SortsUtils.sortShaker(array)));
    }

    /**
     * Cоздание целочисленного массива через консоль
     *
     * @return созданный массив
     */
    public static int[] arrayConsole() {
        int size;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Введите числа: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        return array;
    }
}
