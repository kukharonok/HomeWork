package home.home_work_1.taskcode;

import java.util.Scanner;

/*
 * @author Kukharonok  Andrey
 */
public class BranchesTask6 {
    public static void main(String[] args) {
        int a, b, c;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 3 целых числа: ");
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        scanner.close();
        System.out.println("a = " + a + " b = " + b + " c = " + c);
        if (a + b <= c || a + c <= b || b + c <= a) {
            System.out.println("Такого треугольника не существует.");
        } else if (a != b && a != c && b != c) {
            System.out.println("Треугольник разносторонний.");
        } else if (a == b && b == c) {
            System.out.println("Треугольник равносторонний.");
        } else {
            System.out.println("Треугольник равнобедренный.");
        }
    }
}
