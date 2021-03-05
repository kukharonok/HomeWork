package home.home_work_3.runners;

/**
 * 4.1 + 15 * 7 + (28 / 5) ^ 2
 */
public class WithoutCalculatorMain {

    public static void main(String[] args) {

        double result = 4.1 + 15 * 7 + Math.pow(((double) 28 / 5), 2);

        System.out.println(result); //140.45999999999998
    }
}
