package home.home_work_7;

import home.home_work_6.api.ISearchEngine;
import home.home_work_7.utils.Utils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class LogFileRepeatedWords {

    private final File folder;
    private File booksName;
    private final File fileResult;
    private final ISearchEngine searchEngine;
    private File[] listFiles;
    private String textBook;

    public LogFileRepeatedWords(String nameFolder, String nameFileResult, ISearchEngine searchEngine) {
        this.folder = new File(nameFolder);
        this.fileResult = new File(nameFileResult);
        this.searchEngine = searchEngine;
    }

    private void setListFiles() {
        File[] listFiles = this.folder.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            throw new IllegalArgumentException("данный путь к папке не существует или папка пустая");
        }
        this.listFiles = listFiles;
    }

    private void printListFiles() {
        for (File fileIn : this.listFiles) {
            System.out.println(fileIn.getName());
        }
    }

    private File findBooksName(String s) {
        if (this.listFiles != null) {
            for (File temp : this.listFiles) {
                if (temp.getName().equals(s)) {
                    return temp;
                }
            }
        }
        return null;
    }

    private void setBooksName() {
        boolean flag;
        File name = null;
        do {
            flag = false;
            System.out.println("Выберите текст, с которым мы будем работать: ");
            String text = Utils.acceptRequestConsole();
            name = findBooksName(text);
            if (name == null) {
                System.err.println("Неправильно ввели название книги, попытайтесь снова");
                flag = true;
            }
        } while (flag);
        this.booksName = name;
    }

    private void setTextBook() {
        String text = null;
        try {
            text = Files.readString(Path.of(this.booksName.getAbsolutePath()), Charset.forName("windows-1251"));
            this.textBook = text;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private void writerWordsToFile() {
        try (FileWriter writer = new FileWriter(this.fileResult, this.fileResult.exists())) {
            String word = null;
            do {
                System.out.print("Что будем искать в тексте? (для выхода введите exit) Введите слово: ");
                word = Utils.acceptRequestConsole();
                if (word.equals("exit")) {
                    break;
                }
                long l = this.searchEngine.search(this.textBook, word);
                writer.write(booksName.getName() + " – " + word + " - " + l + "\r\n");
            } while (true);
            writer.flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void start() {
        setListFiles();
        printListFiles();
        setBooksName();
        setTextBook();
        writerWordsToFile();
    }
}
