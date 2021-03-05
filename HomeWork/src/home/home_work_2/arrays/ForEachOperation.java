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

public class ForEachOperation implements IArraysOperation {

    @Override
    public String arrayToString(int[] array) {
        StringBuilder b = new StringBuilder();
        int max = array.length - 1;
        b.append('[');
        int count = 0;
        for (int temp : array) {
            if (count == max) {
                b.append(temp).append(']');
            } else {
                b.append(temp).append(' ');
            }
            count++;
        }
        return b.toString();
    }

    @Override
    public String arrayToStringEverySecond(int[] array) {
        StringBuilder b = new StringBuilder();
        int max = array.length - 1;
        b.append('[');
        int count = 0;
        for (int temp : array) {
            if (!(count % 2 == 0)) {
                if (count == max) {
                    b.append(temp).append(']');
                } else {
                    b.append(temp).append(' ');
                }
            }
            count++;
        }
        return b.toString();
    }

    @Override
    public String arrayToStringReverse(int[] array) {
        StringBuilder s = new StringBuilder();
        int count = 0;
        for (int temp : array) {
            if (count == 0) {
                s.insert(0, temp + "]");
            } else {
                s.insert(0, temp + " ");
            }
            count++;
        }
        return s.insert(0, "[").toString();
    }
}
