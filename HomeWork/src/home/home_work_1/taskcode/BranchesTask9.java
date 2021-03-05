package home.home_work_1.taskcode;

import java.util.Scanner;

/*
 * @author Kukharonok  Andrey
 */
public class BranchesTask9 {
    public static void main(String[] args) {
        int a, b, c;
        double x1, x2;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите коэффициент квадратного уравнения a: ");
        a = scanner.nextInt();
        System.out.print("Введите коэффициент квадратного уравнения b: ");
        b = scanner.nextInt();
        System.out.print("Введите коэффициент квадратного уравнения c: ");
        c = scanner.nextInt();
        scanner.close();
        int discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Корень квадратного уравнения x1 = " + x1);
            System.out.println("Корень квадратного уравнения x2 = " + x2);
        } else if (discriminant == 0) {
            x1 = (double) -b / (2 * a);
            System.out.println("Корень квадратного уравнения x = " + x1);
        }
        else {
            System.out.println("Корней нет в квадратном уравнении" );
        }
    }
}
