package home.home_work_3.runners;

import home.home_work_3.calcs.additional.CalculatorWithCounterAutoComposite;
import home.home_work_3.calcs.simple.CalculatorWithMathCopy;
import home.home_work_3.calcs.simple.CalculatorWithMathExtends;
import home.home_work_3.calcs.simple.CalculatorWithOperator;

public class CalculatorWithCounterAutoCompositeMain {

    public static void main(String[] args) {

        CalculatorWithCounterAutoComposite cal = new CalculatorWithCounterAutoComposite(new CalculatorWithOperator());
        double res1 = cal.add(cal.add(4.1, cal.multiply(15, 7)), cal.pow(cal.div(28, 5), 2));
        System.out.println("Результат экземпляра CalculatorWithOperator: " + res1); //140.45999999999998
        System.out.println("countOperation экземпляра CalculatorWithOperator: " + cal.getCountOperation()); //5

        CalculatorWithCounterAutoComposite cal2 = new CalculatorWithCounterAutoComposite(new CalculatorWithMathCopy());
        double res2 = cal2.add(cal2.add(4.1, cal2.multiply(15, 7)), cal2.pow(cal2.div(28, 5), 2));
        System.out.println("Результат экземпляра CalculatorWithMathCopy: " + res2); //140.45999999999998
        System.out.println("countOperation экземпляра CalculatorWithMathCopy: " + cal2.getCountOperation()); //5

        CalculatorWithCounterAutoComposite cal3 =
                new CalculatorWithCounterAutoComposite(new CalculatorWithMathExtends());
        double res3 = cal3.add(cal3.add(4.1, cal3.multiply(15, 7)), cal3.pow(cal3.div(28, 5), 2));
        System.out.println("Результат экземпляра CalculatorWithMathExtends: " + res3); //140.45999999999998
        System.out.println("countOperation экземпляра CalculatorWithMathExtends: " + cal3.getCountOperation()); //5

    }
}
