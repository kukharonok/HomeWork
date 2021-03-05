package home.home_work_1.taskcode;

import java.util.Scanner;

/*
 * @author Kukharonok  Andrey
 */
public class BranchesTask2 {
    public static void main(String[] args) {
        int x, y;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число: ");
        x = scanner.nextInt();
        scanner.close();
        if (x > 0) {
            y = 2 * x - 10;
        } else if (x == 0) {
            y = 0;
        } else {
            y = 2 * Math.abs(x) - 1;
        }
        System.out.println("значение функции y = " + y);
    }
}
