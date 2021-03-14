package home.home_work_9;

import home.home_work_6.api.ISearchEngine;
import home.home_work_6.search.RegExSearch;
import home.home_work_9.dto.Book;
import home.home_work_9.utils.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogFileMain {

    public static void main(String[] args) {
        String folder = null;
        try {
            folder = (args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Не введены данные");
            e.printStackTrace();
            return;
        }
        File[] listBooks = new File(folder).listFiles();
        if (listBooks == null || listBooks.length == 0) {
            throw new IllegalArgumentException("данный путь к папке не существует или папка пустая");
        }

        File fileResult = new File("result.txt");

        ISearchEngine searchEngine = new RegExSearch();

        try (FileWriter writer = new FileWriter(fileResult, fileResult.exists())) {
            String s = null;
            do {
                Utils.printListFiles(listBooks);
                boolean flag;
                File nameOfBook = null;
                do {
                    flag = false;
                    System.out.println("Выберите книгу, с которым мы будем работать (для выхода введите exit): ");
                    s = Utils.acceptRequestConsole();
                    if (s.equals("exit")) {
                        break;
                    }
                    nameOfBook = Utils.getNameOfBook(listBooks, s);
                    if (nameOfBook == null) {
                        System.err.println("Неправильно ввели название книги, попытайтесь снова");
                        flag = true;
                    }
                } while (flag);
                if (nameOfBook == null) {
                    break;
                }
                Book book = new Book(nameOfBook);
                do {
                    System.out.print("Что будем искать в тексте? (для выхода введите exit) Введите слово: ");
                    s = Utils.acceptRequestConsole();
                    if (s.equals("exit")) {
                        break;
                    }
                    long numberOfRepetitions = searchEngine.search(book.textOfBook(), s);
                    writer.write(book.getNameOfBooks().getName() + " – " + s + " - " + numberOfRepetitions + "\r\n");
                } while (true);
            } while (true);
            writer.flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}


