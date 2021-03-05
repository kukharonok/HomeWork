package home.home_work_1.taskcode;

import java.util.Scanner;

/*
 * @author Kukharonok  Andrey
 */
public class BranchesTask8 {
    public static void main(String[] args) {
        int x, y;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите координату точки х: ");
        x = scanner.nextInt();
        System.out.print("Введите координату точки y: ");
        y = scanner.nextInt();
        scanner.close();
        if (x > 0 && y > 0) {
            System.out.println("Точка принадлежит I четверти");
        } else if (x < 0 && y > 0) {
            System.out.println("Точка принадлежит II четверти");
        } else if (x < 0 && y < 0) {
            System.out.println("Точка принадлежит III четверти");
        } else if (x > 0 && y < 0) {
            System.out.println("Точка принадлежит IV четверти");
        } else if (x == 0 && y == 0) {
            System.out.println("Точка находиться в начале координат");
        } else {
            System.out.println("Точка лежит на оси");
        }
    }
}
