package home.home_work_3.calcs;

import home.home_work_3.calcs.additional.*;
import home.home_work_3.calcs.api.ICalculator;
import home.home_work_3.calcs.simple.CalculatorWithMathCopy;
import home.home_work_3.calcs.simple.CalculatorWithMathExtends;
import home.home_work_3.calcs.simple.CalculatorWithOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * 3. Написать тест который будет тестировать все реализации ICalculator. Пример 4.1 + 15 * 7 + (28 / 5) ^ 2
 */

public class CalculatorTest {

    static Stream<Arguments> calcArgumentProvider() {
        return Stream.of(
                Arguments.arguments(new CalculatorWithMathCopy()),
                Arguments.arguments(new CalculatorWithMathExtends()),
                Arguments.arguments(new CalculatorWithOperator()),
                arguments(new CalculatorWithCounterAutoCompositeInterface(new CalculatorWithMathExtends())),
                arguments(new CalculatorWithCounterAutoDecorator(new CalculatorWithMathCopy())),
                arguments(new CalculatorWithCounterAutoSuper()),
                arguments(new CalculatorWithCounterClassic()),
                arguments(new CalculatorWithMemory()),
                arguments(new CalculatorWithMemoryDecorator(new CalculatorWithMathExtends()))
        );
    }

    @ParameterizedTest
    @DisplayName("Сложение")
    @MethodSource("calcArgumentProvider")
    public void additionTest(ICalculator calculator) {
        assertAll("calculator name",
                () -> assertEquals(109.1, calculator.add(4.1, 105), 0.0001),
                () -> assertEquals(0, calculator.add(-0.1, 0.1), 0.0001),
                () -> assertEquals(0.141, calculator.add(0.01, 0.131), 0.0001)
        );
    }

    @ParameterizedTest
    @DisplayName("Вычитание")
    @MethodSource("calcArgumentProvider")
    public void subtractionTest(ICalculator calculator) {
        assertAll("calculator name",
                () -> assertEquals(0, calculator.subtract(1, 1), 0.0001),
                () -> assertEquals(2.47, calculator.subtract(2.48, 0.01), 0.0001),
                () -> assertEquals(0, calculator.subtract(0.1, 0.1), 0.0001),
                () -> assertEquals(0.14, calculator.subtract(0.15, 0.01), 0.0001)
        );
    }

    @ParameterizedTest
    @DisplayName("Умножение")
    @MethodSource("calcArgumentProvider")
    public void multiplyTest(ICalculator calculator) {
        assertAll("calculator name",
                () -> assertEquals(105, calculator.multiply(15, 7), 0.0001),
                () -> assertEquals(0, calculator.multiply(-3, 0), 0.0001),
                () -> assertEquals(2.2, calculator.multiply(1.1, 2), 0.0001)
        );
    }

    @ParameterizedTest
    @DisplayName("Деление")
    @MethodSource("calcArgumentProvider")
    public void divisionTest(ICalculator calculator) {
        assertAll("calculator name",
                () -> assertEquals(5.6, calculator.div(28, 5), 0.0001),
                () -> assertEquals(Double.NEGATIVE_INFINITY, calculator.div(-1.0, 0.0), 0.0001),
                () -> assertEquals(Double.POSITIVE_INFINITY, calculator.div(1.0, 0.0), 0.0001),
                () -> assertEquals(Double.NaN, calculator.div(0.0, 0.0), 0.0001)
        );
    }

    @ParameterizedTest
    @DisplayName("Возведение в степень")
    @MethodSource("calcArgumentProvider")
    public void powTest(ICalculator calculator) {
        assertAll("calculator name",
                () -> assertEquals(31.36, calculator.pow(5.6, 2), 0.0001),
                () -> assertEquals(1, calculator.pow(-1.0, 0), 0.0001)
        );
    }

    @ParameterizedTest
    @DisplayName("Абсолютное значение переданного аргумента")
    @MethodSource("calcArgumentProvider")
    public void absTest(ICalculator calculator) {
        assertAll("calculator name",
                () -> assertEquals(5.6, calculator.absNumber(5.6), 0.0001),
                () -> assertEquals(1.0, calculator.absNumber(-1.0), 0.0001),
                () -> assertEquals(0.0, calculator.absNumber(-0.0), 0.0001)
        );
    }

    @ParameterizedTest
    @DisplayName("квадратный корень из числа")
    @MethodSource("calcArgumentProvider")
    public void sqrtTest(ICalculator calculator) {
        assertAll("calculator name",
                () -> assertEquals(2, calculator.sqrtNumber(4), 0.0001),
                () -> assertEquals(2.8284, calculator.sqrtNumber(8), 0.0001),
                () -> assertEquals(0.0, calculator.sqrtNumber(0.0), 0.0001),
                () -> assertEquals(5.6, calculator.sqrtNumber(31.36), 0.0001)
        );
    }
}
