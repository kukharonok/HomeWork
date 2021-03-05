package home.home_work_1.taskcode;

import java.util.Scanner;

/*
 * @author Kukharonok  Andrey
 */
public class BranchesTask3 {
    public static void main(String[] args) {
        int x, y;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 2 целых числа: ");
        x = scanner.nextInt();
        y = scanner.nextInt();
        scanner.close();
        if (y != 0) {
            if (x % y == 0) {
                System.out.println("Число " + x + " делится нацело на число " + y);
            } else {
                System.out.println("Число " + x + " не делится на число " + y + "; Остаток от деления = " + x % y);
            }
            double div = (double) x / y;
            System.out.println("Частное чисел = " + div);
        } else {
            System.out.println("На 0 делить нельзя!");
        }
    }
}
