package home.home_work_2.loops;

/**
 * 1.5. Вывести таблицу умножения в консоль. В консоли должно получиться также как и на картинке
 * (динозаврика рисовать не надо):
 * https://www.dropbox.com/s/ibakfuppvy2w32g/multiplication_table.jpeg?dl=0
 */

public class MultiplicationTable {

    public static void printMultiplicationTable() {
        createTable(2, 5);
        System.out.println("________________________________________");
        createTable(6, 9);
    }

    private static void createTable(int firstElement, int lastElement) {
        for (int i = 1; i <= 10; i++) {
            for (int j = firstElement; j <= lastElement; j++) {
                if (j != lastElement) {
                    System.out.printf("%dx%2d=%2d  | ", j, i, (i * j));
                } else {
                    System.out.printf("%dx%2d=%2d  ", j, i, (i * j));
                }
            }
            System.out.println();
        }
    }
}
