package home.home_work_3.calcs.simple;

import home.home_work_3.calcs.api.ICalculator;

/*
 * @author Kukharonok Andrey
 */
public class CalculatorWithMathCopy implements ICalculator {

    /**
     * Возвращает сумму 2-х аргументов
     *
     * @param a- первое значение
     * @param b- второе значение
     * @return результат сложения
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Возвращает разность 2-х аргументов
     *
     * @param a- первое значение
     * @param b- второе значение
     * @return результат разности
     */
    public double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Возвращает произведение 2-х аргументов
     *
     * @param a- первое значение
     * @param b- второе значение
     * @return результат произведения
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Возвращает частное 2-х аргументов
     *
     * @param a–делимое
     * @param b-делитель
     * @return результат деления
     */
    public double div(double a, double b) {
            return a / b;
    }

    /**
     * Возвращает значение первого аргумента в степени второго аргумента.
     *
     * @param a - аргумент
     * @param b - показатель степени.
     * @return результат возведения в степень
     */
    public double pow(double a, int b) {
        return Math.pow(a, b);
    }

    /**
     * Возвращает абсолютное значение переданного аргумента double
     *
     * @param a - аргумент, абсолютное значение которого необходимо определить
     * @return абсолютное значение аргумента
     */
    public double absNumber(double a) {
        return Math.abs(a);
    }

    /**
     * Возвращает положительный квадратный корень
     *
     * @param a - значение.
     * @return положительный квадратный корень из a
     */
    public double sqrtNumber(double a) {
        return Math.sqrt(a);
    }

}
