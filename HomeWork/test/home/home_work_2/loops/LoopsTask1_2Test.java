package home.home_work_2.loops;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LoopsTask1_2Test {

    @ParameterizedTest(name = "{index} a = {0}, результат ожидаем {1}")
    @DisplayName("Test method multiplyNumbers")
    @MethodSource("multiplyNumbersArgumentProvider")
    public void multiplyNumbersTest(String a, String c) {
        assertEquals(c, LoopsTask1_2.multiplyNumbers(a));
    }

    static Stream<Arguments> multiplyNumbersArgumentProvider() {
        return Stream.of(
                arguments("181232375", "1 * 8 * 1 * 2 * 3 * 2 * 3 * 7 * 5 = 10080"),
                arguments("12345", "1 * 2 * 3 * 4 * 5 = 120"),
                arguments("253", "2 * 5 * 3 = 30")
        );
    }

    @ParameterizedTest(name = "{index} a = {0}")
    @MethodSource("ArgumentProvider")
    @DisplayName("Ожидание исключения IllegalArgumentException из метода multiplyNumbers")
    public void multiplyNumbersExceptionTest(String a) {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> LoopsTask1_2.multiplyNumbers(a));
        assertEquals("Data entered incorrectly", exception.getMessage());
    }

    static Stream<Arguments> ArgumentProvider() {
        return Stream.of(
                arguments("1.5rt"),
                arguments("привет")
        );
    }


}
