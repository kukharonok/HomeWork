package home.home_work_3.calcs.additional;

import home.home_work_3.calcs.simple.CalculatorWithMathExtends;

/*
 * @author Kukharonok Andrey
 */
public class CalculatorWithCounterAutoSuper extends CalculatorWithMathExtends {

    /**
     * количество использований калькулятора
     */
    private long countOperation;

    /**
     * Возвращает количество использований данного калькулятора
     *
     * @return текущее количество использований калькулятора
     */
    public long getCountOperation() {
        return countOperation;
    }

    /**
     * Возвращает значение первого аргумента в степени второго аргумента.
     * Учитывается количество использований данного калькулятора
     *
     * @param a - аргумент
     * @param b - показатель степени.
     * @return результат возведения в степень
     */
    @Override
    public double pow(double a, int b) {
        countOperation++;
        return super.pow(a, b);
    }

    /**
     * Возвращает абсолютное значение переданного аргумента double
     * Учитывается количество использований данного калькулятора
     *
     * @param a - аргумент, абсолютное значение которого необходимо определить
     * @return абсолютное значение аргумента
     */
    @Override
    public double absNumber(double a) {
        countOperation++;
        return super.absNumber(a);
    }

    /**
     * Возвращает положительный квадратный корень
     * Учитывается количество использований данного калькулятора
     *
     * @param a - значение.
     * @return положительный квадратный корень из a
     */
    @Override
    public double sqrtNumber(double a) {
        countOperation++;
        return super.sqrtNumber(a);
    }

    /**
     * Возвращает сумму 2-х аргументов
     * Учитывается количество использований данного калькулятора
     *
     * @param a- первое значение
     * @param b- второе значение
     * @return результат сложения
     */
    @Override
    public double add(double a, double b) {
        countOperation++;
        return super.add(a, b);
    }

    /**
     * Возвращает разность 2-х аргументов
     * Учитывается количество использований данного калькулятора
     *
     * @param a- первое значение
     * @param b- второе значение
     * @return результат разности
     */
    @Override
    public double subtract(double a, double b) {
        countOperation++;
        return super.subtract(a, b);
    }

    /**
     * Возвращает произведение 2-х аргументов
     * Учитывается количество использований данного калькулятора
     *
     * @param a- первое значение
     * @param b- второе значение
     * @return результат произведения
     */
    @Override
    public double multiply(double a, double b) {
        countOperation++;
        return super.multiply(a, b);
    }

    /**
     * Возвращает частное 2-х аргументов
     * Учитывается количество использований данного калькулятора
     *
     * @param a – делимое
     * @param b - делитель
     * @return результат деления, сли b =0 , возвращает Double.NaN
     */
    @Override
    public double div(double a, double b) {
        countOperation++;
        return super.div(a, b);
    }
}
