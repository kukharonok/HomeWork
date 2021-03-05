package home.home_work_2.arrays;

import java.util.Random;
import java.util.Scanner;

public class ArraysPrintMethods {

    public static void main(String[] args) {

        int[] container = arrayFromConsole();

        arrayPrintForeach(container);
        arrayPrintFor(container);
        arrayPrintWhile(container);
        arrayPrintDoWhile(container);
        System.out.println();

        arrayPrintEverySecondFor(container);
        arrayPrintEverySecondWhile(container);
        arrayPrintEverySecondDoWhile(container);
        arrayPrintEverySecondForeach(container);
        System.out.println();

        arrayPrintReverseForeach(container);
        arrayPrintReverseFor(container);
        arrayPrintReverseWhile(container);
        arrayPrintReverseDoWhile(container);
        System.out.println();

        int[] container2 = arrayRandom(10, 100);

        arrayPrintForeach(container2);

    }

    /**
     * Получаем целочисленный массив с вводом значений через консоль.
     * Ввод значений прекращается про вводе exit
     *
     * @return целочисленный массив
     */
    public static int[] arrayFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Введите числа для заполнения массива; для остановки ввода введите слово exit");
        for (int i = 0; i < array.length; i++) {
            String s = scanner.next();
            if (!(s.equals("exit"))) {
                array[i] = Integer.parseInt(s);
            } else {
                return array;
            }
        }
        scanner.close();
        return array;
    }

    /**
     * Печать в консоль массива, используя цикл Foreach
     *
     * @param array целочисленный массив.
     */
    public static void arrayPrintForeach(int[] array) {
        for (int temp : array) {
            System.out.print(temp + " ");
        }
        System.out.println();
    }

    /**
     * Печать в консоль массива, используя цикл For
     *
     * @param array целочисленный массив.
     */
    public static void arrayPrintFor(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * Печать в консоль массива, используя цикл While
     *
     * @param array целочисленный массив.
     */
    public static void arrayPrintWhile(int[] array) {
        int i = 0;
        while (i < array.length) {
            System.out.print(array[i] + " ");
            i++;
        }
        System.out.println();
    }

    /**
     * Печать в консоль массива, используя цикл do...while
     *
     * @param array целочисленный массив.
     */
    public static void arrayPrintDoWhile(int[] array) {
        int i = 0;
        do {
            System.out.print(array[i] + " ");
            i++;
        } while (i < array.length);
        System.out.println();
    }

    /**
     * Печать в консоль каждого второго значения массива, используя цикл Foreach
     *
     * @param array целочисленный массив.
     */
    public static void arrayPrintEverySecondForeach(int[] array) {
        int count = 0;
        for (int temp : array) {
            if (!(count % 2 == 0)) {
                System.out.print(temp + " ");
            }
            count++;
        }
        System.out.println();
    }

    /**
     * Печать в консоль каждого второго значения массива, используя цикл For
     *
     * @param array целочисленный массив.
     */
    public static void arrayPrintEverySecondFor(int[] array) {
        for (int i = 1; i < array.length; i += 2) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * Печать в консоль каждого второго значения массива, используя цикл While
     *
     * @param array целочисленный массив.
     */
    public static void arrayPrintEverySecondWhile(int[] array) {
        int i = 1;
        while (i < array.length) {
            System.out.print(array[i] + " ");
            i += 2;
        }
        System.out.println();
    }

    /**
     * Печать в консоль каждого второго значения массива, используя цикл do...while
     *
     * @param array целочисленный массив.
     */
    public static void arrayPrintEverySecondDoWhile(int[] array) {
        int i = 1;
        do {
            System.out.print(array[i] + " ");
            i += 2;
        } while (i < array.length);
        System.out.println();
    }

    /**
     * Печать элементов массива в консоль в обратном порядке, используя цикл Foreach
     *
     * @param array целочисленный массив.
     */
    public static void arrayPrintReverseForeach(int[] array) {
        StringBuilder s = new StringBuilder();
        for (int temp : array) {
            s.insert(0, temp + " ");
        }
        System.out.println(s);
    }

    /**
     * Печать элементов массива в консоль в обратном порядке, используя цикл For
     *
     * @param array целочисленный массив.
     */
    public static void arrayPrintReverseFor(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * Печать элементов массива в консоль в обратном порядке, используя цикл While
     *
     * @param array целочисленный массив.
     */
    public static void arrayPrintReverseWhile(int[] array) {
        int i = array.length - 1;
        while (i >= 0) {
            System.out.print(array[i] + " ");
            i--;
        }
        System.out.println();
    }

    /**
     * Печать элементов массива в консоль в обратном порядке, используя цикл do...while
     *
     * @param array целочисленный массив.
     */
    public static void arrayPrintReverseDoWhile(int[] array) {
        int i = array.length - 1;
        do {
            System.out.print(array[i] + " ");
            i--;
        } while (i >= 0);
        System.out.println();
    }

    /**
     * Получаем рандомный целочисленный массив
     *
     * @param size              размер будущего массива
     * @param maxValueExclusion значение, до которого генерируются рандомные числа
     * @return рандомный массив размером size
     */
    public static int[] arrayRandom(int size, int maxValueExclusion) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(maxValueExclusion);
        }
        return arr;
    }
}
