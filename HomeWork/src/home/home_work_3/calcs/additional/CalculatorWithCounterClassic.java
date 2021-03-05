package home.home_work_3.calcs.additional;

import home.home_work_3.calcs.simple.CalculatorWithMathExtends;

/*
 * @author Kukharonok Andrey
 */
public class CalculatorWithCounterClassic extends CalculatorWithMathExtends {

    /**
     * количество использований калькулятора
     */
    private long countOperation;

    /**
     * Увеличивает количество использований калькулятора на 1
     */
    public void incrementCountOperation() {
        countOperation += 1;
    }

    /**
     * Возвращает количество использований данного калькулятора
     *
     * @return текущее количество использований калькулятора
     */
    public long getCountOperation() {
        return countOperation;
    }
}
