package home.home_work_2.loops;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LoopsTask1_4Test {

    @ParameterizedTest(name = "{index} a = {0}, результат ожидаем {1}")
    @DisplayName("Test method multiplyToOverflow")
    @MethodSource("multiplyToOverflowArgumentProvider")
    public void multiplyNumbersTest(int a, String c) {
        assertEquals(c, LoopsTask1_4.multiplyToOverflow(a));
    }

    static Stream<Arguments> multiplyToOverflowArgumentProvider() {
        return Stream.of(
                arguments(3, "before overflow: 4052555153018976267; after overflow: -6289078614652622815"),
                arguments(188, "before overflow: 1560496482665168896; after overflow: -1774566438301073408"),
                arguments(-19, "before overflow: 799006685782884121; after overflow: 3265617043834753317"),
                arguments(564, "before overflow: 32186564504948736; after overflow: -293521692918464512")
        );
    }
}
