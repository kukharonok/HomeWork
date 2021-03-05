package home.home_work_1.taskcode;

import java.util.Scanner;

/*
 * @author Kukharonok  Andrey
 */
public class BranchesTask4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int a = scanner.nextInt();
        System.out.println("Укажите направление перевода байты (b) или килобайты (k)");
        String s = scanner.next();
        scanner.close();
        switch (s) {
            case "b":
                System.out.println("число в байтах = " + a * 1024);
                break;
            case "k": {
                double d = a / 1024.0;
                System.out.println("число в килобайтах = " + d);
                break;
            }
            default:
                System.out.println("Неправильно задано направление");
                break;
        }
    }

}
