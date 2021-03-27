package home.home_work_9.dto;

import java.io.File;

public class BookFactory {

    public Book getBook(File fileBook) {
        return new Book(fileBook);
    }
}
