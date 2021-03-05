package home.home_work_3.calcs.additional;

import home.home_work_3.calcs.api.ICalculator;

/*
 * @author Kukharonok Andrey
 */
public class CalculatorWithCounterAutoDecorator implements ICalculator {

    /**
     * количество использований калькулятора
     */
    private long countOperation;

    /**
     * Переданный калькулятор, который реализует интерфейс ICalculator
     */
    private ICalculator calculator;

    /**
     * Конструктор создает обьект {@code CalculatorWithCounterAutoDecorator}
     *
     * @param calculator - обьект который реализует интерфейс ICalculator {@code ICalculator}
     */
    public CalculatorWithCounterAutoDecorator(ICalculator calculator) {
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
     * Метод делегирует действие вспомогательному классу, экземпляр которого хранит в своем поле calculator
     *
     * @param a - аргумент
     * @param b - показатель степени.
     * @return результат возведения в степень
     */
    @Override
    public double pow(double a, int b) {
        countOperation++;
        return this.calculator.pow(a, b);
    }

    /**
     * Возвращает абсолютное значение переданного аргумента double
     * Учитывается количество использований данного калькулятора
     * Метод делегирует действие вспомогательному классу, экземпляр которого хранит в своем поле calculator
     *
     * @param a - аргумент, абсолютное значение которого необходимо определить
     * @return абсолютное значение аргумента
     */
    @Override
    public double absNumber(double a) {
        countOperation++;
        return this.calculator.absNumber(a);
    }

    /**
     * Возвращает положительный квадратный корень
     * Учитывается количество использований данного калькулятора
     * Метод делегирует действие вспомогательному классу, экземпляр которого хранит в своем поле calculator
     *
     * @param a - значение.
     * @return положительный квадратный корень из a
     */
    @Override
    public double sqrtNumber(double a) {
        countOperation++;
        return this.calculator.sqrtNumber(a);
    }

    /**
     * Возвращает сумму 2-х аргументов
     * Учитывается количество использований данного калькулятора
     * Метод делегирует действие вспомогательному классу, экземпляр которого хранит в своем поле calculator
     *
     * @param a - первое значение
     * @param b - второе значение
     * @return результат сложения
     */
    @Override
    public double add(double a, double b) {
        countOperation++;
        return this.calculator.add(a, b);
    }

    /**
     * Возвращает разность 2-х аргументов
     * Учитывается количество использований данного калькулятора
     * Метод делегирует действие вспомогательному классу, экземпляр которого хранит в своем поле calculator
     *
     * @param a - первое значение
     * @param b - второе значение
     * @return результат разности
     */
    @Override
    public double subtract(double a, double b) {
        countOperation++;
        return this.calculator.subtract(a, b);
    }

    /**
     * Возвращает произведение 2-х аргументов
     * Учитывается количество использований данного калькулятора
     * Метод делегирует действие вспомогательному классу, экземпляр которого хранит в своем поле calculator
     *
     * @param a - первое значение
     * @param b - второе значение
     * @return результат произведения
     */
    @Override
    public double multiply(double a, double b) {
        countOperation++;
        return this.calculator.multiply(a, b);
    }

    /**
     * Возвращает частное 2-х аргументов
     * Учитывается количество использований данного калькулятора
     * Метод делегирует действие вспомогательному классу, экземпляр которого хранит в своем поле calculator
     *
     * @param a – делимое
     * @param b -делитель
     * @return результат деления, если b =0, возвращает Double.NaN
     */
    @Override
    public double div(double a, double b) {
        countOperation++;
        return this.calculator.div(a, b);
    }
}
