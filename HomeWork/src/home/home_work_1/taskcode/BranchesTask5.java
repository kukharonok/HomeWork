package home.home_work_1.taskcode;

import java.util.Scanner;

/*
 * @author Kukharonok  Andrey
 */
public class BranchesTask5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число от [0 до 65535]: ");
        int n = scanner.nextInt();
        scanner.close();
        char ch = (char) n;
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            System.out.println("Это код английской буквы " + ch);
        } else {
            System.out.println(ch + " Это иной символ");
        }
    }
}
