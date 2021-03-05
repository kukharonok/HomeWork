package home.home_work_6;

import home.home_work_6.search.EasySearch;
import home.home_work_6.search.RegExSearch;
import home.home_work_6.search.SearchEngineIgnoreCaseDecorator;
import home.home_work_6.search.SearchEnginePunctuationNormalizer;
import home.home_work_6.api.ISearchEngine;
import home.home_work_6.api.ITextSpliterator;
import home.home_work_6.text.DefaultTextSpliterator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class SearchEngineMain {

    public static void main(String[] args) {

        String text = null;
        try {
            text = Files.readString(Path.of("Война и мир_книга.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ITextSpliterator spliterator = new DefaultTextSpliterator();
        List<String> wordsList = spliterator.split(text);
        System.out.println("wordsList size: " + wordsList.size());//290577

        Set<String> wordSet = new HashSet<>(wordsList);
        System.out.println("wordsSet size: " + wordSet.size()); //40616

        Map<String, Integer> wordMap = buildWordMap(wordsList);
        System.out.println("wordMap size: " + wordMap.size());//40616

        List<Map.Entry<String, Integer>> list = sortByValueInDecreasingOrder(wordMap);
        System.out.println("Топ N слов в тексте:");
        printTopNumberWords(list, 5);
        /* Топ N слов в тексте:
         * и - 13874 раз
         * в - 6483 раз
         * не - 5717 раз
         * что - 4746 раз
         * он - 4092 раз
         */

        ISearchEngine search1 = new SearchEngineIgnoreCaseDecorator(new RegExSearch());
        System.out.println(search1.search(text, "Мир"));//33
        System.out.println(search1.search(text, "Война"));//51
        System.out.println(search1.search(text, "И"));//14600

        ISearchEngine search2 = new SearchEnginePunctuationNormalizer(new RegExSearch());
        System.out.println(search2.search(text, "Мир"));//0
        System.out.println(search2.search(text, "Война"));//5
        System.out.println(search2.search(text, "И"));//726

        ISearchEngine search3 = new SearchEnginePunctuationNormalizer(new EasySearch());
        System.out.println(search3.search(text, "мир"));//33
        System.out.println(search3.search(text, "война"));//46
        System.out.println(search3.search(text, "и"));//13874
    }

    /**
     * Метод печатает в консоль топ слов из списка List
     *
     * @param list передаваемый список слов
     * @param topNumber число топовых слов, необходимых для вывода
     */
    public static void printTopNumberWords(List<Map.Entry<String, Integer>> list, int topNumber) {
        int count = 0;
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " раз");
            count++;
            if (count == topNumber) {
                break;
            }
        }
    }

    /**
     * Метод возвращает список слов в виде коллекции Map, где Key - само слово,
     * а Value - количество повторений данного слова в списке
     *
     * @param list передаваемый список слов List
     * @return список слов в виде коллекции Map<String, Integer>
     */
    public static Map<String, Integer> buildWordMap(List<String> list) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : list) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, (wordMap.get(word) + 1));
            } else {
                wordMap.put(word, 1);
            }
        }
        return wordMap;
    }

    /**
     * Метод возвращает отсортированный список слов в виде List<Map.Entry<String, Integer>>,
     * сортирует его по значению Value, тоесть по числу повторов слова в списке
     *
     * @param wordMap передаваемый список слов в виде коллекции Map<String, Integer>
     * @return отсортированный список слов в виде List<Map.Entry<String, Integer>>
     */
    public static List<Map.Entry<String, Integer>> sortByValueInDecreasingOrder(Map<String, Integer> wordMap) {
        Set<Map.Entry<String, Integer>> entries = wordMap.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(entries);
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        return list;
    }
}
