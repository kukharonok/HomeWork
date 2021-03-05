package home.home_work_6.search;

import home.home_work_6.api.ISearchEngine;

import java.util.Locale;
import java.util.regex.Pattern;

public class SearchEngineIgnoreCaseDecorator implements ISearchEngine {

    /**
     * Переданный поисковик, который реализует интерфейс ISearchEngine
     */
    private final ISearchEngine engine;

    /**
     * Конструктор создает обьект {@code SearchEngineIgnoreCaseDecorator}
     *
     * @param engine обьект который реализует интерфейс ISearchEngine {@code ISearchEngine}
     */
    public SearchEngineIgnoreCaseDecorator(ISearchEngine engine) {
        this.engine = engine;
    }

    /**
     * Метод возвращает информации о количестве встречающихся слов в тексте.
     *
     * @param text текст в котором ищем слово
     * @param word слово, которое ищем в тексте
     * @return количество встречающихся слов
     */
    @Override
    public long search(String text, String word) {
        int flags;
        if (this.engine instanceof RegExSearch) {
            flags = Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE;
            RegExSearch regExSearch =(RegExSearch) this.engine;
            regExSearch.setFlag(flags);
            return regExSearch.search(text, word);
        } else {
            return this.engine.search(text.toLowerCase(Locale.ROOT), word.toLowerCase(Locale.ROOT));
        }
    }
}
