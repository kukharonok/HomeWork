package home.home_work_4;

import home.home_work_4.dto.Car;
import home.home_work_4.containers.DataContainer;

import java.util.Iterator;

public class DataContainerCarMain {


    public static void main(String[] args) {

        Car[] data = new Car[]{
                (new Car(2001, "Renault")),
                null,
                (new Car(2000, "Mercedes")),
                null,
                (new Car(2019, "Nissan")),
                (new Car(1654, "Opel"))};

        DataContainer<Car> box = new DataContainer<>(data);

        System.out.println("Size= " + box.getSize());
        box.printArray();

        DataContainer.sort(box);
        box.printArray();

        box.sort(Car.manufactureYearComparator);
        box.printArray();

        box.sort(Car.modelComparator);
        box.printArray();

        DataContainer.sort(box, Car.manufactureYearComparator);
        box.printArray();

        DataContainer.sort(box, Car.modelComparator);
        box.printArray();

        //Явное использование итератора
        Iterator<Car> i = box.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        for (Car car : box) {
            System.out.println(car);
        }
    }
}