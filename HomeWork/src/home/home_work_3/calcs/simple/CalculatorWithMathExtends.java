package home.home_work_3.calcs.simple;

import home.home_work_3.calcs.api.ICalculator;

/*
 * @author Kukharonok Andrey
 */
public class CalculatorWithMathExtends extends CalculatorWithOperator implements ICalculator {

    /**
     * Возвращает значение первого аргумента в степени второго аргумента, используя класс Math
     *
     * @param a - аргумент
     * @param b - показатель степени.
     * @return результат возведения в степень
     */
    @Override
    public double pow(double a, int b) {
        return Math.pow(a, b);
    }

    /**
     * Возвращает абсолютное значение переданного аргумента double, используя класс Math
     *
     * @param a - аргумент, абсолютное значение которого необходимо определить
     * @return абсолютное значение аргумента
     */
    @Override
    public double absNumber(double a) {
        return Math.abs(a);
    }

    /**
     * Возвращает положительный квадратный корень, используя класс Math
     *
     * @param a - значение.
     * @return положительный квадратный корень из a
     */
    @Override
    public double sqrtNumber(double a) {
        return Math.sqrt(a);
    }
}
