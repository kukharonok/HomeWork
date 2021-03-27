package home.home_work_9.dto;

import home.home_work_6.api.ISearchEngine;

import java.io.File;
import java.util.concurrent.Callable;


public class TaskSearch implements Callable<String> {

    private final BookFactory bookFactory;
    private final File pathBook;
    private final String word;
    private final ISearchEngine searchEngine;

    public TaskSearch(BookFactory bookFactory, File pathBook, String word, ISearchEngine searchEngine) {
        this.bookFactory = bookFactory;
        this.pathBook = pathBook;
        this.word = word;
        this.searchEngine = searchEngine;
    }

    @Override
    public String call() {
        // String currentThread = Thread.currentThread().getName();
        Book b = this.bookFactory.getBook(this.pathBook);
        long numberOfRepetitions = searchEngine.search(b.textOfBook(), word);
        //return b.getName() + " – " + this.word + " - " + numberOfRepetitions + " - " + currentThread + "\r\n";
        return b.getName() + " – " + this.word + " - " + numberOfRepetitions + "\r\n";
    }

}
