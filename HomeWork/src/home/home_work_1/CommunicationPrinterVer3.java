package home.home_work_1;

import home.home_work_1.api.ICommunicationPrinter;

/*
 * @author Kukharonok  Andrey
 */

public class CommunicationPrinterVer3 implements ICommunicationPrinter {

    /**
     * Метод возвращает сообщение для данного человека
     *
     * @param name Имя человека
     * @return сообщение для данного человека
     */
    @Override
    public String welcom(String name) {
        switch (name) {
            case "Вася":
                return "Привет!\nЯ тебя так долго ждал\n";
            case "Анастасия":
                return "Я тебя так долго ждал";
            default:
                return "Добрый день, а вы кто?";
        }
    }
}

