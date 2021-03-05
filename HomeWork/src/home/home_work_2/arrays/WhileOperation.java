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

public class WhileOperation implements IArraysOperation {

    @Override
    public String arrayToString(int[] array) {
        StringBuilder b = new StringBuilder();
        int max = array.length - 1;
        b.append('[');
        int i = 0;
        while (i < array.length) {
            if (i == max) {
                b.append(array[i]).append(']');
            } else {
                b.append(array[i]).append(' ');
            }
            i++;
        }
        return b.toString();
    }

    @Override
    public String arrayToStringEverySecond(int[] array) {
        StringBuilder b = new StringBuilder();
        int max = array.length - 1;
        b.append('[');
        int i = 1;
        while (i < array.length) {
            if (i == max) {
                b.append(array[i]).append(']');
            } else {
                b.append(array[i]).append(' ');
            }
            i += 2;
        }
        return b.toString();
    }

    @Override
    public String arrayToStringReverse(int[] array) {
        StringBuilder b = new StringBuilder();
        b.append('[');
        int i = array.length - 1;
        while (i >= 0) {
            if (i == 0) {
                b.append(array[i]).append(']');
            } else {
                b.append(array[i]).append(' ');
            }
            i--;
        }
        return b.toString();
    }
}
