package home.home_work_3.runners;

import home.home_work_3.calcs.additional.CalculatorWithCounterAutoCompositeInterface;
import home.home_work_3.calcs.simple.CalculatorWithMathCopy;
import home.home_work_3.calcs.simple.CalculatorWithMathExtends;
import home.home_work_3.calcs.simple.CalculatorWithOperator;

public class CalculatorWithCounterAutoCompositeInterfaceMain {

    public static void main(String[] args) {

        CalculatorWithCounterAutoCompositeInterface c1 =
                new CalculatorWithCounterAutoCompositeInterface(new CalculatorWithOperator());
        double result1 = c1.add(c1.add(4.1, c1.multiply(15, 7)), c1.pow(c1.div(28, 5), 2));
        System.out.println(result1); //140.45999999999998
        System.out.println(c1.getCountOperation()); //5

        CalculatorWithCounterAutoCompositeInterface c2 =
                new CalculatorWithCounterAutoCompositeInterface(new CalculatorWithMathExtends());
        double result2 = c2.add(c2.add(4.1, c2.multiply(15, 7)), c2.pow(c2.div(28, 5), 2));
        System.out.println(result2); //140.45999999999998
        System.out.println(c2.getCountOperation()); //5

        CalculatorWithCounterAutoCompositeInterface c3 =
                new CalculatorWithCounterAutoCompositeInterface(new CalculatorWithMathCopy());
        double result3 = c3.add(c3.add(4.1, c3.multiply(15, 7)), c3.pow(c3.div(28, 5), 2));
        System.out.println(result3); //140.45999999999998
        System.out.println(c3.getCountOperation()); //5

    }
}
