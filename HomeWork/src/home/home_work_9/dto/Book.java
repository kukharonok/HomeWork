package home.home_work_9.dto;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class Book {

    private String textOfBook;
    private final String name;

    public Book(File fileNameOfBook) {
        this.name = fileNameOfBook.getName();
        String text = null;
        try {
            text = Files.readString(Path.of(fileNameOfBook.getAbsolutePath()), Charset.forName("windows-1251"));
            this.textOfBook = text;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public String textOfBook() {
        return this.textOfBook;
    }

    public String getName() {
        return this.name;
    }
}
