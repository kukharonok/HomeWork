package home.home_work_1.taskcode;

import java.util.Scanner;

/*
 * @author Kukharonok  Andrey
 */
public class BranchesTask11 {
    public static void main(String[] args) {
        int a, b, c;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 3 разных числа: ");
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        scanner.close();
        if ((a > b && a < c) || (a < b && a > c)) {
            System.out.println("Среднее число: " + a);
        } else if ((b > a && b < c) || (b < a && b > c)) {
            System.out.println("Среднее число: " + b);
        } else {
            System.out.println("Среднее число: " + c);
        }
    }
}
