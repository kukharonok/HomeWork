package home.home_work_3.calcs.additional;

import home.home_work_3.calcs.simple.CalculatorWithMathCopy;
import home.home_work_3.calcs.simple.CalculatorWithMathExtends;
import home.home_work_3.calcs.simple.CalculatorWithOperator;

/*
 * @author Kukharonok Andrey
 */
public class CalculatorWithCounterAutoComposite {

    /**
     * количество использований калькулятора
     */
    private long countOperation;

    /**
     * Калькулятор класса CalculatorWithOperator
     */
    private CalculatorWithOperator calculatorWithOperator;

    /**
     * Калькулятор класса CalculatorWithMathCopy
     */
    private CalculatorWithMathCopy calculatorWithMathCopy;

    /**
     * Калькулятор класса CalculatorWithMathExtends
     */
    private CalculatorWithMathExtends calculatorWithMathExtends;

    /**
     * Конструктор создает обьект {@code CalculatorWithCounterAutoComposite}
     *
     * @param calculatorWithOperator - обьект {@code CalculatorWithOperator}
     */
    public CalculatorWithCounterAutoComposite(CalculatorWithOperator calculatorWithOperator) {
        this.calculatorWithOperator = calculatorWithOperator;
    }

    /**
     * Конструктор создает обьект {@code CalculatorWithCounterAutoComposite}
     *
     * @param calculatorWithMathCopy - обьект {@code CalculatorWithMathCopy}
     */
    public CalculatorWithCounterAutoComposite(CalculatorWithMathCopy calculatorWithMathCopy) {
        this.calculatorWithMathCopy = calculatorWithMathCopy;
    }

    /**
     * Конструктор создает обьект {@code CalculatorWithCounterAutoComposite}
     *
     * @param calculatorWithMathExtends - обьект {@code CalculatorWithMathExtends}
     */
    public CalculatorWithCounterAutoComposite(CalculatorWithMathExtends calculatorWithMathExtends) {
        this.calculatorWithMathExtends = calculatorWithMathExtends;
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
     * Возвращает сумму 2-х аргументов
     * Учитывается количество использований данного калькулятора
     *
     * @param a- первое значение
     * @param b- второе значение
     * @return результат сложения
     */
    public double add(double a, double b) {
        countOperation++;
        if (calculatorWithOperator != null) {
            return calculatorWithOperator.add(a, b);
        } else if (calculatorWithMathCopy != null)
            return calculatorWithMathCopy.add(a, b);
        else {
            return calculatorWithMathExtends.add(a, b);
        }
    }

    /**
     * Возвращает разность 2-х аргументов
     * Учитывается количество использований данного калькулятора
     *
     * @param a- первое значение
     * @param b- второе значение
     * @return результат разности
     */
    public double subtract(double a, double b) {
        countOperation++;
        if (calculatorWithOperator != null) {
            return calculatorWithOperator.subtract(a, b);
        } else if (calculatorWithMathCopy != null)
            return calculatorWithMathCopy.subtract(a, b);
        else {
            return calculatorWithMathExtends.subtract(a, b);
        }
    }

    /**
     * Возвращает произведение 2-х аргументов
     * Учитывается количество использований данного калькулятора
     *
     * @param a- первое значение
     * @param b- второе значение
     * @return результат произведения
     */
    public double multiply(double a, double b) {
        countOperation++;
        if (calculatorWithOperator != null) {
            return calculatorWithOperator.multiply(a, b);
        } else if (calculatorWithMathCopy != null)
            return calculatorWithMathCopy.multiply(a, b);
        else {
            return calculatorWithMathExtends.multiply(a, b);
        }
    }

    /**
     * Возвращает частное 2-х аргументов
     * Учитывается количество использований данного калькулятора
     *
     * @param a – делимое
     * @param b - делитель
     * @return результат деления
     * если b = 0 , возвращает Double.NaN
     */
    public double div(double a, double b) {
        countOperation++;
        if (calculatorWithOperator != null) {
            return calculatorWithOperator.div(a, b);
        } else if (calculatorWithMathCopy != null)
            return calculatorWithMathCopy.div(a, b);
        else {
            return calculatorWithMathExtends.div(a, b);
        }
    }

    /**
     * Возвращает значение первого аргумента в степени второго аргумента.
     * Учитывается количество использований данного калькулятора
     *
     * @param a - аргумент
     * @param b - показатель степени.
     * @return результат возведения в степень
     */
    public double pow(double a, int b) {
        countOperation++;
        if (calculatorWithOperator != null) {
            return calculatorWithOperator.pow(a, b);
        } else if (calculatorWithMathCopy != null)
            return calculatorWithMathCopy.pow(a, b);
        else {
            return calculatorWithMathExtends.pow(a, b);
        }
    }

    /**
     * Возвращает абсолютное значение переданного аргумента double
     * Учитывается количество использований данного калькулятора
     *
     * @param a - аргумент, абсолютное значение которого необходимо определить
     * @return абсолютное значение аргумента
     */
    public double absNumber(double a) {
        countOperation++;
        if (calculatorWithOperator != null) {
            return calculatorWithOperator.absNumber(a);
        } else if (calculatorWithMathCopy != null)
            return calculatorWithMathCopy.absNumber(a);
        else {
            return calculatorWithMathExtends.absNumber(a);
        }
    }

    /**
     * Возвращает положительный квадратный корень
     * Учитывается количество использований данного калькулятора
     *
     * @param a - значение.
     * @return положительный квадратный корень из a
     */
    public double sqrtNumber(double a) {
        countOperation++;
        if (calculatorWithOperator != null) {
            return calculatorWithOperator.sqrtNumber(a);
        } else if (calculatorWithMathCopy != null)
            return calculatorWithMathCopy.sqrtNumber(a);
        else {
            return calculatorWithMathExtends.sqrtNumber(a);
        }
    }
}
