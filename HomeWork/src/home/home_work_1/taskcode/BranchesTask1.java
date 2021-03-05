package home.home_work_1.taskcode;

import java.util.Scanner;

/*
 * @author Kukharonok  Andrey
 */
public class BranchesTask1 {
    public static void main(String[] args) {
        int a, b, c;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 3 целых числа: ");
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        scanner.close();
        if (a >= b && a >= c) {
            System.out.println("Максимальное число: " + a);
        } else if (b >= a && b >= c) {
            System.out.println("Максимальное число: " + b);
        } else {
            System.out.println("Максимальное число: " + c);
        }
    }
}
