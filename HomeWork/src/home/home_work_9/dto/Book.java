package home.home_work_9.dto;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class Book {

    private String textOfBook;
    private final File nameOfBook;

    public Book(File nameOfBook) {
        this.nameOfBook = nameOfBook;
        String text = null;
        try {
            if (nameOfBook != null) {
                text = Files.readString(Path.of(nameOfBook.getAbsolutePath()), Charset.forName("windows-1251"));
            }
            this.textOfBook = text;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public String textOfBook() {
        return this.textOfBook;
    }

    public File getNameOfBooks() {
        return this.nameOfBook;
    }
}
