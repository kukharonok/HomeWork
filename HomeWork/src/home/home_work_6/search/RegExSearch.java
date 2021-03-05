package home.home_work_6.search;

import home.home_work_6.api.ISearchEngine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * @author Kukharonok Andrey
 */
public class RegExSearch implements ISearchEngine {

    /**
     * Флаг для класса Pattern - маска, которая может включать CASE_INSENSITIVE, MULTILINE, DOTALL, UNICODE_CASE,
     * CANON_EQ, UNIX_LINES, LITERAL, UNICODE_CHARACTER_CLASS и COMMENTSE
     */
    private int flags;

    /**
     * Установка флага для класса Pattern
     *
     * @param flag Флаг для класса Pattern
     */
    public void setFlag(int flag) {
        this.flags = flag;
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
        String regex = "(?<=[^а-я0-9А-ЯёЁ-])" + word + "(?=[^а-я0-9А-ЯёЁ-])";
        Pattern pattern = Pattern.compile(regex, this.flags);
        Matcher matcher = pattern.matcher(text);
        long count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
