package home.home_work_4;

import home.home_work_4.containers.DataContainer;

import java.util.Iterator;

public class DataContainerIntegerMain {

    public static void main(String[] args) {

        DataContainer<Integer> box = new DataContainer<>(5);
        System.out.println("Size=" + box.getSize() + " SizeWithNull=" + box.getSizeWithNull());//Size=0 SizeWithNull=0
        box.add(88);
        box.add(7);
        System.out.println(box.toString()); // [88, 7]
        System.out.println("Size=" + box.getSize() + " SizeWithNull=" + box.getSizeWithNull());//Size=2 SizeWithNull=2
        System.out.println(box.add(null)); // -1
        System.out.println(box.get(1)); // 7
        System.out.println(box.get(0)); // 88
        System.out.println(box.get(2));// null
        box.add(4);
        box.add(11);
        System.out.println(box.toString()); // [88, 7, 4, 11]
        System.out.println("Size=" + box.getSize() + " SizeWithNull=" + box.getSizeWithNull());//Size=4 SizeWithNull=4
        box.delete(1);
        box.delete(Integer.valueOf(88));
        System.out.println(box.toString()); //[4, 11]
        System.out.println("Size=" + box.getSize() + " SizeWithNull=" + box.getSizeWithNull());//Size=2 SizeWithNull=2
        box.add(54);
        box.add(99);

        //Явное использование итератора
        Iterator<Integer> i = box.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        for (Integer integer : box) {
            System.out.println(integer);
        }
    }
}
