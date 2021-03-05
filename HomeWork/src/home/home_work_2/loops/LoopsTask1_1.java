package home.home_work_2.loops;

/**
 * 1.1. Перемножить числа от 1 до числа (включительно) введенного через аргумент к исполняемой
 * программе. Есть нюанс с переполнением, можно добавить проверки и сообщения пользователю.
 * Пример: Ввели 5, должно получиться в консоли: 1 * 2 * 3 * 4 * 5 = ответ
 * 1.1.1. Используя только цикл
 * 1.1.2.* Используя рекурсию
 */

public class LoopsTask1_1 {

    /**
     * Нахождение факториала числа n исползуя цикл
     *
     * @param a целое число
     * @return факториал числа a
     * @throws ArithmeticException      если результат переполняет значение long
     * @throws IllegalArgumentException если передаваемое число < 0
     */
    public static long calculatingFactorialUseLoop(int a) {
        long result = 1;
        if (a == 0) {
            return result;
        }
        if (a < 0) {
            throw new IllegalArgumentException("Data entered incorrectly");
        }
        for (int i = 1; i <= a; i++) {
            result *= i;
            if (result < 0) {
                throw new ArithmeticException("long overflow");
            }
        }
        return result;
    }

    /**
     * Нахождение факториала числа n исползуя рекурсию
     *
     * @param n целое число
     * @return факториал числа n
     * @throws ArithmeticException      если результат переполняет значение long
     * @throws IllegalArgumentException если передаваемое число < 0
     */
    static long calculatingFactorialUseRecursion(int n) {
        long result = 1;
        if (n == 0) {
            return result;
        }
        if (n == 1) {
            return result;
        }
        if (n < 0) {
            throw new IllegalArgumentException("Data entered incorrectly");
        }
        result = n * calculatingFactorialUseRecursion(n - 1);
        if (result < 0) {
            throw new ArithmeticException("long overflow");
        }
        return result;
    }

    public static String ArgumentFactorialToString(int a) {
        int i = 1;
        StringBuilder s = new StringBuilder();
        while (i < a) {
            s.append(i).append(" * ");
            i++;
        }
        if (i == a) {
            s.append(i).append(" = ");
        }
        return s.toString();
    }
}


