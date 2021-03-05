package home.home_work_2.loops;

import java.util.regex.Pattern;

/**
 * 1.2. Все цифры из числа введенного через аргумент к исполняемой программе перемножить между собой и вывести ход
 * вычислений в консоль. Пользователь обязан ввести целое число. Если ввели не целое то выдать сообщение о том что
 * пользователь ввёл некорректные данные.
 * 1.2.1 Пример: Ввели 181232375, должно получиться в консоли: 1 * 8 * 1 * 2 * 3 * 2 * 3 * 7 * 5 = 10 080
 * 1.2.2 Пример: Ввели 99.2, должно получиться в консоли: Введено не целое число
 * 1.2.3 Пример: Ввели Привет, должно получиться в консоли: Введено не число
 */
public class LoopsTask1_2 {

    /**
     * Метод возвращает строку в виде перемножения всех цифр вводимого целого положительного числа
     *
     * @param args целое положительное число
     * @return строку в виде перемножения всех цифр вводимого числа, например: 1 * 4 * 1 * 5 = 20
     * @throws ArithmeticException      если результат вычисления произведения цифр переполняет значение long
     * @throws IllegalArgumentException если не корректно передано целое положительное число
     */
    public static String multiplyNumbers(String args) {
        if (!isInteger(args)) {
            throw new IllegalArgumentException("Data entered incorrectly");
        }
        char[] chars = args.toCharArray();
        long multi = 1;
        int number = 0;
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            number = Character.getNumericValue(chars[i]);
            multi *= number;
            if (multi < 0) {
                throw new ArithmeticException("long overflow");
            }
            if (i == chars.length - 1) {
                s.append(number).append(" = ");
            } else {
                s.append(number).append(" * ");
            }
        }
        return s.append(multi).toString();
    }

    /**
     * Проверка корректности строки на наличие целого положительного числа
     *
     * @param s проверяемая строка класса String
     * @return true - если введено целое положительное число, false - если нет
     */
    public static boolean isInteger(String s) {
        return (Pattern.matches("\\d+", s));
    }
}

