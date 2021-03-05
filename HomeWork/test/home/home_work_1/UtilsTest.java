package home.home_work_1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class UtilsTest {

    @ParameterizedTest(name = "{index} a = {0}, b = {1} результат ожидаем {2}")
    @DisplayName("Test method sleepIn")
    @MethodSource("sleepInArgumentProvider")
    public void sleepInTest(boolean a, boolean b, boolean c) {
        assertEquals(c, Utils.sleepIn(a, b));
    }

    static Stream<Arguments> sleepInArgumentProvider() {
        return Stream.of(
                arguments(false, true, true),
                arguments(true, false, false),
                arguments(false, false, true),
                arguments(true, true, true)
        );
    }

    @ParameterizedTest(name = "{index} a = {0}, результат ожидаем {1}")
    @DisplayName("Test method createPhoneNumber")
    @MethodSource("createPhoneNumberArgumentProvider")
    public void createPhoneNumberTest(int[] a, String c) {
        assertEquals(c, Utils.createPhoneNumber(a));
    }

    static Stream<Arguments> createPhoneNumberArgumentProvider() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "(123) 456-7890"),
                arguments(new int[]{1, 3, 3, 7, 5, 7, 6, 8, 6, 7}, "(133) 757-6867")
        );
    }

    @ParameterizedTest(name = "{index} a = {0}")
    @MethodSource("ArgumentProvider")
    @DisplayName("Ожидание Исключения IllegalArgumentException из метода createPhoneNumber")
    public void createPhoneNumberExceptionTest(int[] a) {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> Utils.createPhoneNumber(a));
        assertEquals("Data entered incorrectly", exception.getMessage());
    }

    static Stream<Arguments> ArgumentProvider() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 4, 59, 6, 7, 8, 9, 0}),
                arguments(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 6})
        );
    }

    @ParameterizedTest(name = "{index} a = {0}, результат ожидаем {1}")
    @DisplayName("Test method toBinaryString")
    @MethodSource("toBinaryStringArgumentProvider")
    public void toBinaryStringTest(byte a, String c) {
        assertEquals(c, Utils.toBinaryString(a));
    }

    static Stream<Arguments> toBinaryStringArgumentProvider() {
        return Stream.of(
                arguments((byte)7,"00000111"),
                arguments((byte)-7,"11111001"),
                arguments((byte)15,"00001111"),
                arguments((byte)-15,"11110001")
        );
    }
}
