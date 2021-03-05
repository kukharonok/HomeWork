package home.home_work_3.calcs.additional;

import home.home_work_3.calcs.simple.CalculatorWithOperator;

/*
 * @author Kukharonok Andrey
 */
public class CalculatorWithMemory extends CalculatorWithOperator {

    /**
     * Память калькулятора
     */
    private double memoryValue;

    /**
     * Хранение результата вычислений методов
     */
    private double result;

    /**
     * Возвращает значение из памяти калькулятора, после этого память сразу стирается
     *
     * @return значение из памяти калькулятора
     */
    public double getMemoryValue() {
        double tempMemory = this.memoryValue;
        this.memoryValue = 0;
        return tempMemory;
    }

    /**
     * Запись результата вычисления в память калькулятора
     */
    public void record() {
        this.memoryValue = this.result;
    }

    /**
     * Возвращает значение первого аргумента в степени второго аргумента.
     * Метод делегирует работу родительскому классу, результат записывается в память калькулятора
     *
     * @param a - аргумент
     * @param b - показатель степени.
     * @return результат возведения в степень
     */
    @Override
    public double pow(double a, int b) {
        this.result = super.pow(a, b);
        return this.result;
    }

    /**
     * Возвращает абсолютное значение переданного аргумента double
     * Метод делегирует работу родительскому классу, результат записывается в память калькулятора
     *
     * @param a - аргумент, абсолютное значение которого необходимо определить
     * @return абсолютное значение аргумента
     */
    @Override
    public double absNumber(double a) {
        this.result = super.absNumber(a);
        return this.result;
    }

    /**
     * Возвращает положительный квадратный корень
     * Метод делегирует работу родительскому классу, результат записывается в память калькулятора
     *
     * @param a - значение.
     * @return положительный квадратный корень из a
     */
    @Override
    public double sqrtNumber(double a) {
        this.result = super.sqrtNumber(a);
        return this.result;
    }

    /**
     * Возвращает сумму 2-х аргументов
     * Метод делегирует работу родительскому классу, результат записывается в память калькулятора
     *
     * @param a- первое значение
     * @param b- второе значение
     * @return результат сложения
     */
    @Override
    public double add(double a, double b) {
        this.result = super.add(a, b);
        return this.result;
    }

    /**
     * Возвращает разность 2-х аргументов
     * Метод делегирует работу родительскому классу, результат записывается в память калькулятора
     *
     * @param a- первое значение
     * @param b- второе значение
     * @return результат разности
     */
    @Override
    public double subtract(double a, double b) {
        this.result = super.subtract(a, b);
        return this.result;
    }

    /**
     * Возвращает произведение 2-х аргументов
     * Метод делегирует работу родительскому классу, результат записывается в память калькулятора
     *
     * @param a- первое значение
     * @param b- второе значение
     * @return результат произведения
     */
    @Override
    public double multiply(double a, double b) {
        this.result = super.multiply(a, b);
        return this.result;
    }

    /**
     * Возвращает частное 2-х аргументов
     * Метод делегирует работу родительскому классу, результат записывается в память калькулятора
     *
     * @param a– делимое
     * @param b- делитель
     * @return результат деления; если b = 0, возвращает Double.NaN
     */
    @Override
    public double div(double a, double b) {
        this.result = super.div(a, b);
        return this.result;
    }
}
