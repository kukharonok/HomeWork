package home.home_work_1;

import home.home_work_1.api.ICommunicationPrinter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommunicationPrinterTest {

    static Stream<Arguments> welcomArgumentProvider() {
        return Stream.of(
                Arguments.arguments(new CommunicationPrinterVer1()),
                Arguments.arguments(new CommunicationPrinterVer2()),
                Arguments.arguments(new CommunicationPrinterVer3())
        );
    }

    @ParameterizedTest
    @DisplayName("Test method welcom")
    @MethodSource("welcomArgumentProvider")
    public void additionTest(ICommunicationPrinter communicationPrinter) {
        assertAll("communicationPrinter",
                () -> assertEquals("Привет!\nЯ тебя так долго ждал\n",
                        communicationPrinter.welcom("Вася")),
                () -> assertEquals("Я тебя так долго ждал",
                        communicationPrinter.welcom("Анастасия")),
                () -> assertEquals("Добрый день, а вы кто?",
                        communicationPrinter.welcom("Игорь"))
        );
    }
}

