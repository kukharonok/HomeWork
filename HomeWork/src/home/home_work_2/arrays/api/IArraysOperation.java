package home.home_work_2.arrays.api;

public interface IArraysOperation {

    /**
     * Метод преобразует массив в строку. Элементы массива заключены в квадратные скобки ("[]")
     *
     * @param array передаваемый целочисленный массив
     * @return целочисленный массив в виде строки
     */
    String arrayToString(int[] array);

    /**
     * Метод преобразует массив в строку, учитываются только каждый второй элемент массива.
     * Элементы массива заключены в квадратные скобки ("[]")
     *
     * @param array передаваемый целочисленный массив
     * @return целочисленный массив в виде строки
     */
    String arrayToStringEverySecond(int[] array);

    /**
     * Метод преобразует массив в строку в обратном порядке
     * Элементы массива заключены в квадратные скобки ("[]")
     *
     * @param array передаваемый целочисленный массив
     * @return целочисленный массив в виде строки
     */
    String arrayToStringReverse(int[] array);
}

