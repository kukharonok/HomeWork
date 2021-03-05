package home.home_work_2.loops;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LoopsTask1_1Test {

    @ParameterizedTest(name = "{index} a = {0}, результат ожидаем {1}")
    @DisplayName("Test method calculatingFactorialUseLoop")
    @MethodSource("FactorialUseLoopArgumentProvider")
    public void calculatingFactorialUseLoopTest(int a, long c) {
        assertEquals(c, LoopsTask1_1.calculatingFactorialUseLoop(a));
    }

    static Stream<Arguments> FactorialUseLoopArgumentProvider() {
        return Stream.of(
                arguments(20, 2432902008176640000L),
                arguments(5, 120L),
                arguments(10, 3628800L)
        );
    }

    @ParameterizedTest(name = "{index} a = {0}, результат ожидаем {1}")
    @DisplayName("Test method calculatingFactorialUseRecursion")
    @MethodSource("FactorialUseRecursionArgumentProvider")
    public void calculatingFactorialUseRecursionTest(int a, long c) {
        assertEquals(c, LoopsTask1_1.calculatingFactorialUseRecursion(a));
    }

    static Stream<Arguments> FactorialUseRecursionArgumentProvider() {
        return Stream.of(
                arguments(4, 24L),
                arguments(7, 5040L),
                arguments(15, 1307674368000L)
        );
    }

    @ParameterizedTest(name = "{index} a = {0}")
    @MethodSource("ArithmeticExceptionArgumentProvider")
    @DisplayName("Ожидание исключения ArithmeticException из метода calculatingFactorialUseRecursion")
    public void calculatingFactorialUseRecursionExceptionTest(int a) {
        Exception exception = assertThrows(ArithmeticException.class,
                () -> LoopsTask1_1.calculatingFactorialUseRecursion(a));
        assertEquals("long overflow", exception.getMessage());
    }

    static Stream<Arguments> ArithmeticExceptionArgumentProvider() {
        return Stream.of(
                arguments(21),
                arguments(111)
        );
    }
}
