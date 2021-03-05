package home.home_work_6.text;

import home.home_work_6.api.ITextSpliterator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * @author Kukharonok Andrey
 */
public class DefaultTextSpliterator implements ITextSpliterator {

    /**
     * Метод возвращает список слов в тексте.
     *
     * @param text переданный текст для разбивки по словам
     * @return список слов в виде коллекции List<String>
     */
    @Override
    public List<String> split(String text) {
        String reg = "([0-9а-яА-ЯёЁ]+)-*([0-9а-яА-ЯёЁ]+)*";
        Pattern pattern = Pattern.compile(reg, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(text);
        List<String> wordsList = new ArrayList<>();
        while (matcher.find()) {
            wordsList.add(matcher.group());
        }
        return wordsList;
    }
}
