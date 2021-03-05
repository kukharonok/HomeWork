package home.home_work_6.search;

import home.home_work_6.api.ISearchEngine;

/*
 * @author Kukharonok Andrey
 */
public class EasySearch implements ISearchEngine {

    /**
     * Метод возвращает информации о количестве встречающихся слов в тексте.
     *
     * @param text текст в котором ищем слово
     * @param word слово, которое ищем в тексте
     * @return количество встречающихся слов
     */
    @Override
    public long search(String text, String word) {
        int Length = word.length();
        int textLength = text.length();
        char prevChar;
        char afterChar;
        int wordLength = 0;
        int index = 0;
        long numberRepetitions = 0L;
        while (index != -1) {
            index = text.indexOf(word, index + wordLength);
            if (index == 0) {
                if ((index + Length) == textLength) {
                    numberRepetitions++;
                } else {
                    afterChar = text.charAt(index + Length);
                    if (!Character.isLetterOrDigit(afterChar) && afterChar != '-') {
                        numberRepetitions++;
                    }
                }
            } else if (index > 0 && (index + wordLength == textLength)) {
                prevChar = text.charAt(index - 1);
                if (!Character.isLetterOrDigit(prevChar) && prevChar != '-') {
                    numberRepetitions++;
                }
            } else if (index != -1) {
                afterChar = text.charAt(index + Length);
                prevChar = text.charAt(index - 1);
                if (!Character.isLetterOrDigit(prevChar) &&
                        (!Character.isLetterOrDigit(afterChar)) &&
                        afterChar != '-' && prevChar != '-') {
                    numberRepetitions++;
                }
            }
            wordLength = word.length();
        }
        return numberRepetitions;
    }
}
