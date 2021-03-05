package home.home_work_2.loops;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ExponentiationTest {

    @ParameterizedTest(name = "{index} a = {0}, b = {1} результат ожидаем {2}")
    @DisplayName("Test method powToString")
    @MethodSource("powToStringArgumentProvider")
    public void powToStringTest(double a, int b, double c) {
        assertEquals(c, Exponentiation.powToString(a, b), 0.0001);
    }

    static Stream<Arguments> powToStringArgumentProvider() {
        return Stream.of(
                arguments(18, 5, 1889568.0),
                arguments(7.5, 2, 56.25),
                arguments(4, 2, 16.0),
                arguments(4.5, 5, 1845.28125),
                arguments(1.3, 3, 2.197)
        );
    }
}
