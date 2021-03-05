package home.home_work_2.arrays;

public class TaskCodeArray {

    /**
     * Возвращает сумму четных положительных элементов массива
     *
     * @param array целочисленный массив.
     * @return сумма четных положительных элементов массива
     */
    public static int sumEvenPositiveNumbersArray(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0 && array[i] % 2 == 0) {
                sum += array[i];
            }
        }
        return sum;
    }

    /**
     * Возвращает максимальный из элементов массива с четными индексами
     *
     * @param array целочисленный массив.
     * @return максимальный из элементов массива с четными индексами
     */
    public static int maxEvenNumberArray(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i += 2) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * Метод возвращает элементы массива, которые меньше среднего арифметического в виде строки
     *
     * @param array целочисленный массив.
     * @return элементы массива в виде строки, которые меньше среднего арифметического
     */
    public static String minAverageArithmeticElementsArray(int[] array) {

        StringBuilder b = new StringBuilder();
        double average = 0;

        for (int i = 0; i < array.length; i++) {
            average += array[i];
        }
        average /= array.length;

        for (int temp : array) {
            if (average > temp) {
                b.append(temp).append(' ');
            }
        }
        return b.deleteCharAt(b.length() - 1).toString();
    }

    /**
     * Метод возвращает индексы и значения 2-х наименьших элемента массива в виде строки
     *
     * @param array целочисленный массив.
     * @return индексы и значения 2-х наименьших элемента массива в виде строки
     */
    public static String twoMinElementsArray(int[] array) {
        StringBuilder b = new StringBuilder();
        int idxMin1 = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[idxMin1]) {
                idxMin1 = i;
            }
        }
        b.append("[").append(idxMin1).append("] = ").append(array[idxMin1]).append("; ");

        int idxMin2 = (idxMin1 == 0) ? 1 : 0;
        for (int i = 1; i < array.length; i++) {
            if (i == idxMin1) {
                continue;
            } else if (array[i] < array[idxMin2]) {
                idxMin2 = i;
            }
        }
        b.append("[").append(idxMin2).append("] = ").append(array[idxMin2]);
        return b.toString();
    }

    /**
     * В массиве удаляются элементы, величина которых находится в интервале [а, b], массив сжимается влево,
     * освободившиеся в конце массива элементы заполняются нулями.
     *
     * @param array целочисленный массив.
     * @param start начальный значение интервала [а, b]
     * @param end   конечное значение интервала [а, b]
     * @return массив после удаления элементов
     */
    public static int[] compressRangeArray(int[] array, int start, int end) {
        int[] temp = new int[array.length];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (!(array[i] >= start && array[i] <= end)) {
                temp[j] = array[i];
                j++;
            }
        }
        return temp;
    }

    /**
     * Метод вычисляет суммы цифр всех значений массива. Знак значений массива не учитывается
     *
     * @param array целочисленный массив.
     * @return сумму цифр всех значений массива
     */
    public static int sumNumbersArray(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            int n = Math.abs(array[i]);
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
        }
        return sum;
    }
}









