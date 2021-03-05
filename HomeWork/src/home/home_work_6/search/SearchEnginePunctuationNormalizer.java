package home.home_work_6.search;

import home.home_work_6.api.ISearchEngine;

public class SearchEnginePunctuationNormalizer implements ISearchEngine {

    /**
     * Переданный поисковик, который реализует интерфейс ISearchEngine
     */
    private final ISearchEngine engine;

    /**
     * Конструктор создает обьект {@code SearchEnginePunctuationNormalizer}
     *
     * @param engine обьект который реализует интерфейс ISearchEngine {@code ISearchEngine}
     */
    public SearchEnginePunctuationNormalizer(ISearchEngine engine) {
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
        text = text.replaceAll("([^0-9а-яА-ЯёЁ-])|(--)|(-(?=[\\s+]))|((?<=[\\s+])-)", " ")
                .replaceAll("\\s+", " ");
        return this.engine.search(text, word);
    }
}
