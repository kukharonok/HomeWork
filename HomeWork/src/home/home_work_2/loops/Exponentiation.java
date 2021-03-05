package home.home_work_2.loops;

/**
 * 1.3. Возведение в степень. Через консоль пользователь вводит два числа. Первое число это число которое мы будем
 * возводить, Второе число это степень в которую возводят первое число. Степень - только положительная и целая.
 * Возводимое число - может быть отрицательным и оно будет дробным. Math использовать нельзя.
 * 1.3.1 Пример: Ввели 18 и 5, должно получиться в консоли: 18.0 ^ 5 = 1 889 568.0
 * 1.3.2 Пример: Ввели 7.5 и 2, должно получиться в консоли: 7.5 ^ 2 = 56.25
 */

public class Exponentiation {

    public static double powToString(double a, int b) {
        int i = 1;
        double exp = 1;
        while (i <= b) {
            exp *= a;
            i++;
        }
        return exp;
    }
}
