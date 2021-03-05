package home.home_work_4;

import home.home_work_4.containers.DataContainer;

import java.util.Iterator;

public class DataContainerIntegerNullMain {

    public static void main(String[] args) {

        Integer[] data = new Integer[]{null, null, 8, null, 2, 56, null};
        DataContainer<Integer> box = new DataContainer<>(data);

        for (Integer integer : box) {
            System.out.println(integer);
        }

        System.out.println("Size=" + box.getSize() + " SizeWithNull=" + box.getSizeWithNull()); //Size=3 SizeWithNull=7
        System.out.println(box.delete(null));//true
        System.out.println(box.get(2));//null
        System.out.println(box.get(4)); //56
        System.out.println("Size=" + box.getSize() + " SizeWithNull=" + box.getSizeWithNull()); //Size=3 SizeWithNull=6
        box.printArray(); //DataContainer: [null, 8, null, 2, 56, null]
        box.add(88);
        box.add(7);
        System.out.println("Size=" + box.getSize() + " SizeWithNull=" + box.getSizeWithNull()); //Size=5 SizeWithNull=6
        box.printArray(); //DataContainer: [88, 8, 7, 2, 56, null]
        box.add(45);
        System.out.println("Size=" + box.getSize() + " SizeWithNull=" + box.getSizeWithNull()); //Size=6 SizeWithNull=6
        box.printArray(); //DataContainer: [88, 8, 7, 2, 56, 45]
        box.add(98);
        System.out.println("Size=" + box.getSize() + " SizeWithNull=" + box.getSizeWithNull()); //Size=7 SizeWithNull=7
        box.printArray(); // DataContainer: [88, 8, 7, 2, 56, 45, 98]


        //Явное использование итератора
        Iterator<Integer> i = box.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
