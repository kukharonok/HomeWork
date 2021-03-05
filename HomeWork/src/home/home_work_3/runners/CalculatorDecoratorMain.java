package home.home_work_3.runners;

import home.home_work_3.calcs.additional.CalculatorWithCounterAutoDecorator;
import home.home_work_3.calcs.additional.CalculatorWithMemoryDecorator;
import home.home_work_3.calcs.api.ICalculator;
import home.home_work_3.calcs.simple.CalculatorWithMathExtends;

/**
 * 11*. Создать класс CalculatorWithCounterAutoDecorator и CalculatorWithMemoryDecorator
 * 11.1 Отличие от предыдущих CalculatorWithCounterAutoInterface и CalculatorWithMemory в том что данные классы
 * реализуют интерфейс ICalculator.
 * 11.2 Данный подход позволяет назвать данный классы "Декораторами". Декоратор - это популярный паттерн который
 * позволяет комбинировать и дополнять новыми возможностями объекты (в нашем случае калькуляторы)
 * не меняя код в их классе. Тем самым мы приходим к тому что мы не наследуем классы для их расширения и
 * не привязываемся к реализации конкретного калькулятора.
 * 11.3 О декораторах можно прочитать по ссылкам:
 * 11.3.1 https://refactoring.guru/ru/design-patterns/decorator
 * 11.3.2 https://www.wikiwand.com/ru/%D0%94%D0%B5%D0%BA%D0%BE%D1%80%D0%B0%D1%82%D0%BE%D1%80_(%D1%88%D0%B0%D0%B1%D0%BB%D0%BE%D0%BD_%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F)
 * 11.4 Добавить в эти классы метод ICalculator getCalculator() который будут возвращать вложенный в них калькулятор.
 * 11.5 Создать класс CalculatorDecoratorMain в котором будет точка входа (main метод).
 * Cоздать переменную типа ICalculator записав в неё новый экземпляр класса CalculatorWithCounterDecorator
 * которому в конструктор был передан новый экземпляр класса CalculatorWithMemoryDecorator которому в конструтор
 * был передан новый экземпляр класса CalculatorWithMathExtends.
 * Используя созданную переменную посчитать выражения из задания 1.
 * 11.6 Вывести в консоль результат. Вывести количество использований калькулятора.
 * Вывести последнее сохранённое значение в памяти.
 */
public class CalculatorDecoratorMain {

    public static void main(String[] args) {

        ICalculator calc = new CalculatorWithCounterAutoDecorator(new CalculatorWithMathExtends());

        double result = calc.add(calc.add(4.1, calc.multiply(15, 7)), calc.pow(calc.div(28, 5), 2));

        System.out.println(result); //140.45999999999998

        if (calc instanceof CalculatorWithCounterAutoDecorator) {
            CalculatorWithCounterAutoDecorator calculator = (CalculatorWithCounterAutoDecorator) calc;
            System.out.println(calculator.getCountOperation());  //5
        }

        //пример:  4.1 + 15 * 7 + (28 / 5) ^ 2
        ICalculator cal = new CalculatorWithMemoryDecorator(new CalculatorWithMathExtends());

        if (cal instanceof CalculatorWithMemoryDecorator) {
            CalculatorWithMemoryDecorator calculator = (CalculatorWithMemoryDecorator) cal;
            calculator.div(28, 5);
            calculator.record();
            calculator.pow(calculator.getMemoryValue(), 2);
            calculator.record();
            calculator.add(calculator.getMemoryValue(), 4.1);
            calculator.record();
            calculator.add(calculator.getMemoryValue(), calculator.multiply(15, 7));
            calculator.record();
            System.out.println(calculator.getMemoryValue()); //140.45999999999998 - значение в памяти до очистки
            System.out.println(calculator.getMemoryValue()); //0.0 - в памяти уже 0
        }
    }
}

