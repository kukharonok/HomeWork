package home.home_work_2.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TaskCodeArrayTest {

    @ParameterizedTest(name = "{index} a = {0}, результат ожидаем {1}")
    @DisplayName("Test method sumEvenPositiveNumbersArray")
    @MethodSource("sumEvenPositiveNumbersArrayArgumentProvider")
    public void sumEvenPositiveNumbersArrayTest(int[] a, int c) {
        assertEquals(c, TaskCodeArray.sumEvenPositiveNumbersArray(a));
    }

    static Stream<Arguments> sumEvenPositiveNumbersArrayArgumentProvider() {
        return Stream.of(
                arguments(new int[]{1, 3, 8, 3, 0, 17, 3}, 8),
                arguments(new int[]{5, 2, 8, -5, -3, 86, -8}, 96),
                arguments(new int[]{1, 2, 3, 7, 4, 15, 0}, 6)
        );
    }

    @ParameterizedTest(name = "{index} a = {0}, результат ожидаем {1}")
    @DisplayName("Test method maxEvenNumberArray")
    @MethodSource("maxEvenNumberArrayArgumentProvider")
    public void maxEvenNumberArrayTest(int[] a, int c) {
        assertEquals(c, TaskCodeArray.maxEvenNumberArray(a));
    }

    static Stream<Arguments> maxEvenNumberArrayArgumentProvider() {
        return Stream.of(
                arguments(new int[]{5, 2, 8, -5, -3, 86, -8}, 8),
                arguments(new int[]{-15, 0, 46, -5, -100, -8}, 46),
                arguments(new int[]{1, 2, 3, 7, 4, 15, 0}, 4)
        );
    }

    @ParameterizedTest(name = "{index} a = {0}, результат ожидаем {1}")
    @DisplayName("Test method minAverageArithmeticElementsArray")
    @MethodSource("minAverageArithmeticElementsArrayArgumentProvider")
    public void minAverageArithmeticElementsArrayTest(int[] a, String c) {
        assertEquals(c, TaskCodeArray.minAverageArithmeticElementsArray(a));
    }

    static Stream<Arguments> minAverageArithmeticElementsArrayArgumentProvider() {
        return Stream.of(
                arguments(new int[]{10, 16, 8, -5, -1, 3, -8}, "-5 -1 3 -8"),
                arguments(new int[]{44, 0, 8, -45, -3, 1, 15}, "0 -45 -3 1"),
                arguments(new int[]{1, 2, 15, -36, 4, 3, 0}, "-36")
        );
    }

    @ParameterizedTest(name = "{index} a = {0}, результат ожидаем {1}")
    @DisplayName("Test method twoMinElementsArray")
    @MethodSource("twoMinElementsArrayArgumentProvider")
    public void twoMinElementsArrayTest(int[] a, String c) {
        assertEquals(c, TaskCodeArray.twoMinElementsArray(a));
    }

    static Stream<Arguments> twoMinElementsArrayArgumentProvider() {
        return Stream.of(
                arguments(new int[]{4, 65, 8, -6, -45, -78, 8}, "[5] = -78; [4] = -45"),
                arguments(new int[]{44, 0, 2, -45, -15, 44, 8}, "[3] = -45; [4] = -15"),
                arguments(new int[]{1, 2, 66, 0, 4, 15, 0}, "[3] = 0; [6] = 0")
        );
    }

    @ParameterizedTest(name = "{index} a = {0}, start = {1}, end = {2} результат ожидаем {3}")
    @DisplayName("Test method compressRangeArray")
    @MethodSource("compressRangeArrayArgumentProvider")
    public void compressRangeArrayTest(int[] a, int b, int c, int[] array) {
        assertArrayEquals(array, TaskCodeArray.compressRangeArray(a, b, c));
    }

    static Stream<Arguments> compressRangeArrayArgumentProvider() {
        return Stream.of(
                arguments(new int[]{2, 0, 65, 5, 15, 33, -6}, 4, 40, new int[]{2, 0, 65, -6, 0, 0, 0}),
                arguments(new int[]{4, 0, 1, 5, 8, 17, -3}, 4, 20, new int[]{0, 1, -3, 0, 0, 0, 0}),
                arguments(new int[]{1, 15, 6, 22, -5, 33}, 6, 100, new int[]{1, -5, 0, 0, 0, 0})
        );
    }

    @ParameterizedTest(name = "{index} a = {0}, результат ожидаем {1}")
    @DisplayName("Test method sumNumbersArray")
    @MethodSource("sumNumbersArrayArgumentProvider")
    public void sumNumbersArrayTest(int[] a, int c) {
        assertEquals(c, TaskCodeArray.sumNumbersArray(a));
    }

    static Stream<Arguments> sumNumbersArrayArgumentProvider() {
        return Stream.of(
                arguments(new int[]{2, 1, 13, 0, 10, -6, -4}, 18),
                arguments(new int[]{5, 2, 8, -5, -3, 86, -8}, 45),
                arguments(new int[]{32, 2, 14, 7, 68, 100, 0}, 34)
        );
    }
}
