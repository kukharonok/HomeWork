package home.home_work_6.search;

import home.home_work_6.api.ISearchEngine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SearchEngineTest {

    static Stream<Arguments> searchEngineArgumentProvider() {
        return Stream.of(
                Arguments.arguments(new EasySearch()),
                Arguments.arguments(new RegExSearch()),
                arguments(new SearchEnginePunctuationNormalizer(new EasySearch())),
                arguments(new SearchEnginePunctuationNormalizer(new RegExSearch()))

        );
    }

    @ParameterizedTest
    @DisplayName("Test method search")
    @MethodSource("searchEngineArgumentProvider")
    public void searchTest(ISearchEngine engine) {
        assertAll("search name",
                () -> assertEquals(2,
                        engine.search("привет,как-как как дела! -- как? ,какдела! как-дела", "как")),
                () -> assertEquals(3,
                        engine.search("4-х привет; привет?, привет-привет! привет.", "привет")),
                () -> assertEquals(0,
                        engine.search("Мама мыла раму", ",мыл")),
                () -> assertEquals(1,
                        engine.search("4-хпривет4-х 4-х-4-х 4-х!", "4-х")),
                () -> assertEquals(0,
                        engine.search("-- Не томите нас, виконт, -- сказала она.", "а")),
                () -> assertEquals(0,
                        engine.search("диктовал какому-то невидимому писцу.", "какому"))
        );
    }


    static Stream<Arguments> SearchEngineIgnoreCaseArgumentProvider() {
        return Stream.of(
                arguments(new SearchEngineIgnoreCaseDecorator(new EasySearch())),
                arguments(new SearchEngineIgnoreCaseDecorator(new RegExSearch()))
        );
    }

    @ParameterizedTest
    @DisplayName("Test method search IgnoreCase")
    @MethodSource("SearchEngineIgnoreCaseArgumentProvider")
    public void searchIgnoreCaseTest(ISearchEngine engine) {
        assertAll("SearchEngineIgnoreCaseDecorator name",
                () -> assertEquals(2,
                        engine.search("привет,как-как как! -- Как. ,Какдела! как-дела", "КАк")),
                () -> assertEquals(3,
                        engine.search("4 Привет; привет, Привет-привет Привет.", "ПривеТ")),
                () -> assertEquals(0,
                        engine.search("Мама мыла раму", ",Мыл")),
                () -> assertEquals(1,
                        engine.search("4-Хпривет4-х 4-Х4-Х 4-х!", "4-Х")),
                () -> assertEquals(2,
                        engine.search("-- Не томите нас,нет виконт, не!! -- сказала она.", "НЕ")),
                () -> assertEquals(0,
                        engine.search("диктовал КакомУ-то невидимому писцу.", "КакомУ"))
        );
    }
}
