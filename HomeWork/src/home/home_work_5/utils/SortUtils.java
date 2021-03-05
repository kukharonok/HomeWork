package home.home_work_5.utils;

import java.util.Comparator;
import java.util.List;

public class SortUtils {

    public static <T> void bubbleSort(List<T> container, Comparator<T> comparator) {
        int lengthContainer = container.size();
        for (int j = 1; j < lengthContainer - 1; j++) {
            boolean flagEnd = true;
            for (int i = 0; i < lengthContainer - j; i++) {
                T left = container.get(i);
                T right = container.get(i + 1);
                int compare = comparator.compare(left, right);
                if (compare > 0) {
                    container.set(i, right);
                    container.set(i + 1, left);
                    flagEnd = false;
                }
            }
            if (flagEnd) {
                break;
            }
        }
    }

    public static <T> void shakerSort(List<T> container, Comparator<T> comparator) {

        int lengthContainer = container.size();
        for (int leftDirection = 0, rightDirection = lengthContainer - 1;
             leftDirection < rightDirection; leftDirection++, rightDirection--) {

            for (int i = leftDirection; i < rightDirection; i++) {
                T left = container.get(i);
                T right = container.get(i + 1);
                int compare = comparator.compare(left, right);
                if (compare > 0) {
                    container.set(i, right);
                    container.set(i + 1, left);
                }
            }
            for (int i = rightDirection; i > leftDirection; i--) {
                T left = container.get(i);
                T right = container.get(i - 1);
                int compare = comparator.compare(left, right);
                if (compare < 0) {
                    container.set(i, right);
                    container.set(i - 1, left);
                }
            }
        }
    }
}

