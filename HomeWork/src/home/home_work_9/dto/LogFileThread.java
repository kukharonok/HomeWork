package home.home_work_9.dto;

import home.home_work_6.api.ISearchEngine;
import home.home_work_9.utils.Utils;

import java.io.File;
import java.util.concurrent.Semaphore;

public class LogFileThread implements Runnable {

    private final Semaphore semaphore;
    private final Book book;
    private final String word;
    private final File fileResult;
    private final ISearchEngine searchEngine;

    public LogFileThread(Semaphore semaphore, Book book, String word, File fileResult, ISearchEngine searchEngine) {
        this.semaphore = semaphore;
        this.book = book;
        this.word = word;
        this.fileResult = fileResult;
        this.searchEngine = searchEngine;
    }

    @Override
    public void run() {
        //String currentThread = Thread.currentThread().getName();
        long numberOfRepetitions = searchEngine.search(book.textOfBook(), word);
//        try {
//            Thread.sleep(1000); //для усложнения задачи
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        String result = currentThread + " – " + book.getNameOfBooks().getName() + " – " + this.word +
//                " - " + numberOfRepetitions + "\r\n";
        String result = book.getNameOfBooks().getName() + " – " + this.word + " - " + numberOfRepetitions + "\r\n";
        try {
            //System.out.println("жду разрешения");
            this.semaphore.acquire();
            Utils.writeToFile(result, fileResult);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            //System.out.println("выполнил запись в файл, освобождаю ресурс");
            this.semaphore.release();
        }
    }
}
