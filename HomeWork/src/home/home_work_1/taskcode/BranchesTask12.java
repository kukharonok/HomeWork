package home.home_work_1.taskcode;

/*
 * @author Kukharonok  Andrey
 */
public class BranchesTask12 {
    public static void main(String[] args) {
        int a = (int)(Math.random() * 100);
        int b = (int)(Math.random() * 100);
        if ((a % 2 == 1 && b % 2 == 1) || (a % 2 == 0 && b % 2 == 0)) {
            a += 1;
        }
        System.out.println("Первое число: " + a + "; второе число: " + b);
        if (a % 2 == 1)
            System.out.println("Нечетное число: " + a);
        else
            System.out.println("Нечетное число: " + b);

    }
}
