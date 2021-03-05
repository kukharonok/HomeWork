package home.home_work_3.runners;

import home.home_work_3.calcs.simple.CalculatorWithMathExtends;

public class CalculatorWithMathExtendsMain {

    public static void main(String[] args) {

        CalculatorWithMathExtends calc = new CalculatorWithMathExtends();
        double result = calc.add(calc.add(4.1, calc.multiply(15, 7)), calc.pow(calc.div(28, 5), 2));
        System.out.println(result); //140.45999999999998
    }
}
