package home.home_work_2.sorts;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SortsUtilsTest {

    static Stream<Arguments> ArgumentProvider() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2, 3, 4, 5, 6}),
                arguments(new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 1}),
                arguments(new int[]{9, 1, 5, 99, 9, 9}, new int[]{1, 5, 9, 9, 9, 99}),
                arguments(new int[]{}, new int[]{}),
                arguments(new int[]{4, 45, 66, 2, -6, 0, 13, 77}, new int[]{-6, 0, 2, 4, 13, 45, 66, 77}),
                arguments(new int[]{8, 1, 5, 99, 8, 8}, new int[]{1, 5, 8, 8, 8, 99})
        );
    }

    @ParameterizedTest(name = "{index} a = {0}, результат ожидаем {1}")
    @DisplayName("Test method sortBubble")
    @MethodSource("ArgumentProvider")
    public void sortBubbleTest(int[] a, int[] b) {
        assertArrayEquals(b, SortsUtils.sortBubble(a));
    }

    @ParameterizedTest(name = "{index} a = {0}, результат ожидаем {1}")
    @DisplayName("Test method sortShaker")
    @MethodSource("ArgumentProvider")
    public void sortShakerTest(int[] a, int[] b) {
        assertArrayEquals(b, SortsUtils.sortShaker(a));
    }

    @ParameterizedTest(name = "{index} a = {0}, результат ожидаем {1}")
    @DisplayName("Test method sortSelection")
    @MethodSource("ArgumentProvider")
    public void sortSelectionTest(int[] a, int[] b) {
        assertArrayEquals(b, SortsUtils.sortSelection(a));
    }

    @ParameterizedTest(name = "{index} a = {0}, результат ожидаем {1}")
    @DisplayName("Test method sortInsertion")
    @MethodSource("ArgumentProvider")
    public void sortInsertionTest(int[] a, int[] b) {
        assertArrayEquals(b, SortsUtils.sortInsertion(a));
    }
}
