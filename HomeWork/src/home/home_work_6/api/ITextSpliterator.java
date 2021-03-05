package home.home_work_6.api;

import java.util.List;

/*
 * @author Kukharonok Andrey
 */
public interface ITextSpliterator {

    /**
     * Метод возвращает список слов в тексте.
     *
     * @param text переданный текст для разбивки по словам
     * @return список слов в виде коллекции List<String>
     */
    List<String> split(String text);
}
