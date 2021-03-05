package home.home_work_2.sorts;

public class SortsUtils {

    /**
     * Пузырьковая сортировка массива
     *
     * @param array целочисленный массив
     * @return отсортированный массив
     */
    public static int[] sortBubble(int[] array) {
        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    isSorted = false;

                    buf = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buf;
                }
            }
        }
        return array;
    }

    /**
     * Шейкерная сортировка массива
     *
     * @param array целочисленный массив
     * @return отсортированный массив
     */
    public static int[] sortShaker(int[] array) {
        int start = 0;
        int end = array.length - 1;
        int temp;
        while (start <= end) {
            for (int i = start; i < end; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            end--;

            for (int i = end; i > start; i--) {
                if (array[i] < array[i - 1]) {
                    temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                }
            }
            start++;
        }
        return array;
    }

    /**
     * Cортировка выбором
     *
     * @param array целочисленный массив
     * @return отсортированный массив
     */
    public static int[] sortSelection(int[] array) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            int index = i;

            for (int j = index; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }

            if (index != i) {
                temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }
        return array;
    }

    /**
     * Cортировка вставками
     *
     * @param array целочисленный массив
     * @return отсортированный массив
     */
    public static int[] sortInsertion(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int x = array[i];
            int index = i;

            while (index > 0 && array[index - 1] > x) {
                array[index] = array[index - 1];
                index--;
            }
            array[index] = x;
        }
        return array;
    }
}
