package home.home_work_3.calcs.additional;

import home.home_work_3.calcs.api.ICalculator;

/*
 * @author Kukharonok Andrey
 */
public class CalculatorWithMemoryDecorator implements ICalculator {

    /**
     * Память калькулятора
     */
    private double memoryValue;

    /**
     * Хранение результата вычислений методов
     */
    private double result;

    /**
     * Переданный калькулятор, который реализует интерфейс ICalculator
     */
    private ICalculator calculator;

    /**
     * Конструктор создает обьект {@code CalculatorWithMemoryDecorator}
     *
     * @param calculator - обьект который реализует интерфейс ICalculator {@code ICalculator}
     */
    public CalculatorWithMemoryDecorator(ICalculator calculator) {
        this.calculator = calculator;
    }

    /**
     * Возвращает обьект,который реализует интерфейс ICalculator
     *
     * @return обьект, который реализует интерфейс ICalculator
     */
    public ICalculator getICalculator() {
        return calculator;
    }

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
     * Метод делегирует действие вспомогательному классу, экземпляр которого хранит в своем поле calculator
     * результат записывается в память калькулятора
     *
     * @param a - аргумент
     * @param b - показатель степени.
     * @return результат возведения в степень
     */
    @Override
    public double pow(double a, int b) {
        this.result = this.calculator.pow(a, b);
        return this.result;
    }

    /**
     * Возвращает абсолютное значение переданного аргумента double
     * Метод делегирует действие вспомогательному классу, экземпляр которого хранит в своем поле calculator
     * результат записывается в память калькулятора
     *
     * @param a - аргумент, абсолютное значение которого необходимо определить
     * @return абсолютное значение аргумента
     */
    @Override
    public double absNumber(double a) {
        this.result = this.calculator.absNumber(a);
        return this.result;
    }

    /**
     * Возвращает положительный квадратный корень
     * Метод делегирует действие вспомогательному классу, экземпляр которого хранит в своем поле calculator
     * результат записывается в память калькулятора
     *
     * @param a - значение.
     * @return положительный квадратный корень из a
     */
    @Override
    public double sqrtNumber(double a) {
        this.result = this.calculator.sqrtNumber(a);
        return this.result;
    }

    /**
     * Возвращает сумму 2-х аргументов
     * Метод делегирует действие вспомогательному классу, экземпляр которого хранит в своем поле calculator
     * результат записывается в память калькулятора
     *
     * @param a- первое значение
     * @param b- второе значение
     * @return результат сложения
     */
    @Override
    public double add(double a, double b) {
        this.result = this.calculator.add(a, b);
        return this.result;
    }

    /**
     * Возвращает разность 2-х аргументов
     * Метод делегирует действие вспомогательному классу, экземпляр которого хранит в своем поле calculator
     * результат записывается в память калькулятора
     *
     * @param a- первое значение
     * @param b- второе значение
     * @return результат разности
     */
    @Override
    public double subtract(double a, double b) {
        this.result = this.calculator.subtract(a, b);
        return this.result;
    }

    /**
     * Возвращает произведение 2-х аргументов
     * Метод делегирует действие вспомогательному классу, экземпляр которого хранит в своем поле calculator
     * результат записывается в память калькулятора
     *
     * @param a- первое значение
     * @param b- второе значение
     * @return результат произведения
     */
    @Override
    public double multiply(double a, double b) {
        this.result = this.calculator.multiply(a, b);
        return this.result;
    }

    /**
     * Возвращает частное 2-х аргументов
     * Метод делегирует действие вспомогательному классу, экземпляр которого хранит в своем поле calculator
     * результат записывается в память калькулятора
     *
     * @param a– делимое
     * @param b- делитель
     * @return результат деления; если b =0, возвращает Double.NaN
     */
    @Override
    public double div(double a, double b) {
        this.result = this.calculator.div(a, b);
        return this.result;
    }
}
