package home.home_work_1;

/**
 * 4.* Создать СТАТИЧЕСКИЙ метод sleepIn(Взято с https://codingbat.com/prob/p187868).
 * 4.1 Данный метод будет принимает два параметра
 * 4.2 Будет отвечать на вопрос спать ли дальше (возвращать true либо false).
 * 4.3 Первый параметр boolean weekday обозначает рабочий день
 * 4.4 Второй параметр boolean vacation обозначает отпуск.
 * 4.5 Если у нас отпуск или не рабочий день то мы можем спать дальше
 * <p>
 * 6.* Создать СТАТИЧЕСКИЙ метод createPhoneNumber
 * данный метод будет принимает один параметр и будет возвращать строку в отформатированном виде.
 * В метод будет передаваться массив из 10 цифр (от 0 до 9).
 * Данные цифры должны быть помещены в строку формата: (XXX) XXX-XXXX.
 * Например передан массив: {1,2,3,4,5,6,7,8,9,0}, возвращаемый результат:
 * (123) 456-7890. (Взято с https://www.codewars.com/kata/525f50e3b73515a6db000b83/train/java).
 * В задании нельзя использовать колекции, стрима.
 *
 * 7.** Создать СТАТИЧЕСКИЙ метод String toBinaryString(byte number) и возвращает двоичное представление числа.
 *  В методе можно использовать обычную математику которая описана в теории.
 *  Теория https://planetcalc.ru/747. Если число отрицательное то выдавать дополнительный код. Пример:
 *  7.1 Вводим: 42.  Возвращает: 00101010
 *  7.2 Вводим: 15.  Возвращает: 00001111
 *  7.3 Вводим: -42. Возвращает: 11010110
 *  7.4 Вводим: -15. Возвращает: 11110001
 *
 * @author Kukharonok  Andrey
 */

public class Utils {

    /**
     * Метод возвращает true или false (будем спать или нет) в зависимости от передаваемых параметров
     *
     * @param weekday  обозначает рабочий день
     * @param vacation обозначает отпуск
     * @return Если у нас отпуск или не рабочий день то возвращает true, иначе false
     */
    public static boolean sleepIn(boolean weekday, boolean vacation) {
        return (vacation || !weekday);
    }

    /**
     * Метод возвращает строку в отформатированном виде (XXX) XXX-XXXX
     *
     * @param num массив из 10 цифр
     * @return строка в виде (XXX) XXX-XXXX
     * @throws IllegalArgumentException если не корректно введены данные
     */
    public static String createPhoneNumber(int[] num) {
        int count = 0;
        for (int a : num) {
            if ((a >= 0) && (a / 10) == 0) {
                count++;
            }
        }
        String s = String.format("(%d%d%d) %d%d%d-%d%d%d%d",
                num[0], num[1], num[2], num[3], num[4], num[5], num[6], num[7], num[8], num[9]);
        if ((num.length != 10) || (count < 10)) {
            throw new IllegalArgumentException("Data entered incorrectly");
        }
        return s;
    }

    /**
     * Метод возвращает строку в виде двоичного представления числа
     * @param number число которое будем
     * @return возвращает строку в виде двоичного представления числа; если число отрицательное -
     * то дополнительный код числа
     */
    public static String toBinaryString(byte number) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            s.insert(0, Math.abs((number >> i) % 2));
        }
        return s.toString();
    }
}

