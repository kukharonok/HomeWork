package home.home_work_1.taskcode;

import java.util.Scanner;

/*
 * @author Kukharonok  Andrey
 */
public class BranchesTask7 {
    public static void main(String[] args) {
        int x, y, r;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите координату точки х: ");
        x = scanner.nextInt();
        System.out.print("Введите координату точки y: ");
        y = scanner.nextInt();
        System.out.print("Введите радиус круга r: ");
        r = scanner.nextInt();
        scanner.close();
        if (Math.hypot(x, y) > r) {
            System.out.println("Данная точка не принадлежит кругу.");
        } else {
            System.out.println("Данная точка принадлежит кругу.");
        }
    }
}
