package home.home_work_3.runners;

import home.home_work_3.calcs.additional.CalculatorWithCounterClassic;

public class CalculatorWithCounterClassicMain {

    public static void main(String[] args) {

        double result;
        double temp;
        CalculatorWithCounterClassic calc = new CalculatorWithCounterClassic();

        result = calc.multiply(15, 7);
        calc.incrementCountOperation();
        result = calc.add(4.1, result);
        calc.incrementCountOperation();
        temp = calc.div(28, 5);
        calc.incrementCountOperation();
        temp = calc.pow(temp, 2);
        calc.incrementCountOperation();
        result = calc.add(result, temp);
        calc.incrementCountOperation();

        System.out.println(result); //140.45999999999998
        System.out.println(calc.getCountOperation()); //5
    }

}
