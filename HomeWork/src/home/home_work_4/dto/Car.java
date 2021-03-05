package home.home_work_4.dto;

import java.util.Comparator;
import java.util.Objects;

public class Car implements Comparable<Car> {

    private final int manufactureYear;
    private final String model;

    public Car(int manufactureYear, String model) {

        this.manufactureYear = manufactureYear;
        this.model = model;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Car{" + "manufactureYear= " + this.getManufactureYear() + ", model= " + this.getModel() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return manufactureYear == car.manufactureYear && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufactureYear, model);
    }

    @Override
    public int compareTo(Car o) {
        return (this.getManufactureYear() - o.getManufactureYear());
    }

    /**
     * Comparator для сортировки автомобилей по году выпуска
     */
    public static Comparator<Car> manufactureYearComparator = new Comparator<>() {

        @Override
        public int compare(Car e1, Car e2) {
            if (e1.getManufactureYear() == e2.getManufactureYear()) {
                return 0;
            }
            if (e1.getManufactureYear() > e2.getManufactureYear()) {
                return 1;
            } else {
                return -1;
            }
        }
    };

    /**
     * Comparator для сортировки  автомобилей по модели автомобиля
     */
    public static Comparator<Car> modelComparator = new Comparator<>() {

        @Override
        public int compare(Car e1, Car e2) {
            return e1.getModel().compareTo(e2.getModel());
        }
    };
}
