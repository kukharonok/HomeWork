package home.home_work_2.arrays;

import home.home_work_2.arrays.api.IArraysOperation;

/**
 * 2.3* Выполнить задание 2.2 иным способом. Создать интерфейс IArraysOperation с методами из задания.
 * Написать 4 отдельных класса и реализовать данный интерфейс:
 * 2.3.1. DoWhileOperation - во всех методах можно использовать только do....while
 * 2.3.2. WhileOperation - во всех методах можно использовать только while
 * 2.3.3. ForOperation - во всех методах можно использовать только for
 * 2.3.4. ForEachOperation - во всех методах можно использовать только foreach
 */

public class ForOperation implements IArraysOperation {

    @Override
    public String arrayToString(int[] array) {
        StringBuilder b = new StringBuilder();
        int max = array.length - 1;
        b.append('[');
        for (int i = 0; i < array.length; i++) {
            if (i == max) {
                b.append(array[i]).append(']');
            } else {
                b.append(array[i]).append(' ');
            }
        }
        return b.toString();
    }

    @Override
    public String arrayToStringEverySecond(int[] array) {
        StringBuilder b = new StringBuilder();
        int max = array.length - 1;
        b.append('[');
        for (int i = 1; i < array.length; i += 2) {
            if (i == max) {
                b.append(array[i]).append(']');
            } else {
                b.append(array[i]).append(' ');
            }
        }
        return b.toString();
    }

    @Override
    public String arrayToStringReverse(int[] array) {
        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = array.length - 1; i >= 0; i--) {
            if (i == 0) {
                b.append(array[i]).append(']');
            } else {
                b.append(array[i]).append(' ');
            }
        }
        return b.toString();
    }
}
