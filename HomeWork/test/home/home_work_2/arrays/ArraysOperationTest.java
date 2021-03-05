package home.home_work_2.arrays;

import home.home_work_2.arrays.api.IArraysOperation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArraysOperationTest {

    static Stream<Arguments> arraysOperationProvider() {
        return Stream.of(
                Arguments.arguments(new WhileOperation()),
                Arguments.arguments(new DoWhileOperation()),
                Arguments.arguments(new ForOperation()),
                Arguments.arguments(new ForEachOperation())
        );
    }

    @ParameterizedTest
    @DisplayName("Тест arrayToString")
    @MethodSource("arraysOperationProvider")
    public void arrayToStringTest(IArraysOperation arraysOperation) {
        assertAll("arraysOperation name",
                () -> assertEquals("[1 2 3 4 59 6 7 8 9 0]",
                        arraysOperation.arrayToString(new int[]{1, 2, 3, 4, 59, 6, 7, 8, 9, 0})),
                () -> assertEquals("[0 6 4 455]",
                        arraysOperation.arrayToString(new int[]{0, 6, 4, 455}))
        );
    }

    @ParameterizedTest
    @DisplayName("Тест arrayToStringEverySecond")
    @MethodSource("arraysOperationProvider")
    public void arrayToStringEverySecondTest(IArraysOperation arraysOperation) {
        assertAll("arraysOperation name",
                () -> assertEquals("[2 4 6 8 0]",
                        arraysOperation.arrayToStringEverySecond(new int[]{1, 2, 3, 4, 59, 6, 7, 8, 9, 0})),
                () -> assertEquals("[6 455]",
                        arraysOperation.arrayToStringEverySecond(new int[]{0, 6, 4, 455})),
                () -> assertEquals("[8]",
                        arraysOperation.arrayToStringEverySecond(new int[]{3, 8}))
        );
    }

    @ParameterizedTest
    @DisplayName("Тест arrayToStringReverse")
    @MethodSource("arraysOperationProvider")
    public void arrayToStringReverseTest(IArraysOperation arraysOperation) {
        assertAll("arraysOperation name",
                () -> assertEquals("[6 59 4 3 2 1]",
                        arraysOperation.arrayToStringReverse(new int[]{1, 2, 3, 4, 59, 6})),
                () -> assertEquals("[455 4 6 0]",
                        arraysOperation.arrayToStringReverse(new int[]{0, 6, 4, 455})),
                () -> assertEquals("[8 3]",
                        arraysOperation.arrayToStringReverse(new int[]{3, 8}))
        );
    }
}
