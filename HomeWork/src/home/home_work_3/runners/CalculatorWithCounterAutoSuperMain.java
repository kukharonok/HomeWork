package home.home_work_3.runners;

import home.home_work_3.calcs.additional.CalculatorWithCounterAutoSuper;

public class CalculatorWithCounterAutoSuperMain {

    public static void main(String[] args) {

        CalculatorWithCounterAutoSuper calc = new CalculatorWithCounterAutoSuper();
        double result = calc.add(calc.add(4.1, calc.multiply(15, 7)), calc.pow(calc.div(28, 5), 2));
        System.out.println(result); //140.45999999999998
        System.out.println(calc.getCountOperation()); //5
    }
}
