package home.home_work_4;

import home.home_work_4.containers.DataContainer;

import java.util.Comparator;

public class DataContainerSortComparatorMain {

    public static void main(String[] args) {

        Integer[] data = new Integer[]{8, 4, null, 5, null, 56, null};
        DataContainer<Integer> box3 = new DataContainer<>(data);
        box3.printArray();

        Comparator<Integer> comparator = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                if (o1 > o2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        box3.sort(comparator);
        box3.printArray();

        DataContainer.sort(box3, comparator);
        box3.printArray();

        String[] dataString = new String[]{"hello", null, "good", null, "eat", "drink"};
        DataContainer<String> boxString = new DataContainer<>(dataString);
        boxString.printArray();

        Comparator<String> comparatorString = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 == null && o2 == null) {
                    return 0;
                }
                if (o1 == null) {
                    return -1;
                }
                if (o2 == null) {
                    return 1;
                }
                return o1.compareTo(o2);
            }
        };

        boxString.sort(comparatorString);
        boxString.printArray();

        DataContainer.sort(boxString, comparatorString);
        boxString.printArray();

        for (String s : boxString) {
            System.out.println(s);
        }
    }
}
