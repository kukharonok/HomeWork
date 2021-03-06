package home.home_work_1;

import home.home_work_1.api.ICommunicationPrinter;

import java.util.Objects;

/*
 * @author Kukharonok  Andrey
 */
public class CommunicationPrinterVer2 implements ICommunicationPrinter {

    /**
     * Метод возвращает сообщение для данного человека
     *
     * @param name Имя человека
     * @return сообщение для данного человека
     */
    @Override
    public String welcom(String name) {
        if (Objects.equals(name, "Вася")) {
            return "Привет!\nЯ тебя так долго ждал\n";
        } else if (Objects.equals(name, "Анастасия")) {
            return "Я тебя так долго ждал";
        } else {
            return "Добрый день, а вы кто?";
        }
    }
}
