package home.home_work_4;

import home.home_work_4.containers.DataContainer;

import java.util.Iterator;

public class DataContainerSortComparableMain {

    public static void main(String[] args) {

        Integer[] data = new Integer[]{8, 4, null, 5, null, 56, null};
        DataContainer<Integer> box3 = new DataContainer<>(data);
        box3.printArray();
        DataContainer.sort(box3);
        box3.printArray();

        //Явное использование итератора
        Iterator<Integer> i = box3.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        String[] dataString = new String[]{"hello", null, "good", null, "eat", "drink"};
        DataContainer<String> boxString = new DataContainer<>(dataString);
        boxString.printArray();
        DataContainer.sort(boxString);
        boxString.printArray();

        //Явное использование итератора
        Iterator<String> iterator = boxString.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (String s : boxString) {
            System.out.println(s);
        }
    }
}
