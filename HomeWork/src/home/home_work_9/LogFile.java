package home.home_work_9;

import home.home_work_6.api.ISearchEngine;
import home.home_work_6.search.RegExSearch;
import home.home_work_9.dto.BookFactory;
import home.home_work_9.dto.TaskSearch;
import home.home_work_9.utils.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LogFile {

    private final String folder;
    private File[] listBooks;
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
    private final File fileResult = new File("result.txt");
    private final ISearchEngine searchEngine = new RegExSearch();
    private final List<Future<String>> futures = new ArrayList<>();
    private final BookFactory bookFactory = new BookFactory();


    public LogFile(String folder) {
        this.folder = folder;
    }

    private void setListBooks() {
        File[] listBooks = new File(this.folder).listFiles();
        if (listBooks == null || listBooks.length == 0) {
            throw new IllegalArgumentException("данный путь к папке не существует или папка пустая");
        }
        this.listBooks = listBooks;
    }

    private void find() {
        String word = null;
        boolean flag = false;
        do {
            System.out.print("Что будем искать в книгах? (для выхода введите exit) Введите слово: ");
            word = Utils.acceptRequestConsole();
            if (!word.equals("exit")) {
                for (File file : listBooks) {
                    futures.add(executorService.submit(new TaskSearch(bookFactory, file, word, searchEngine)));
                }
            } else {
                flag = true;
            }
        } while (!flag);
        executorService.shutdown();
    }

    private void buildLog() {
        try (FileWriter writer = new FileWriter(fileResult, fileResult.exists())) {
            for (Future<String> future : futures) {
                writer.write(future.get());
                writer.flush();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (InterruptedException ie) {
            ie.printStackTrace(System.err);
        } catch (ExecutionException ee) {
            ee.printStackTrace(System.err);
        }
    }

    public void start() {
        setListBooks();
        Utils.printListFiles(this.listBooks);
        find();
        buildLog();
    }

}
