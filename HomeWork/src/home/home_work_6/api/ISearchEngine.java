package home.home_work_6.api;

/*
 * @author Kukharonok Andrey
 */
public interface ISearchEngine {

    /**
     * Метод возвращает информации о количестве встречающихся слов в тексте.
     *
     * @param text текст в котором ищем слово
     * @param word слово, которое ищем в тексте
     * @return количество встречающихся слов
     */
    long search(String text, String word);

}
