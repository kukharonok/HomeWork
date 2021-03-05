package home.home_work_1.api;

/**
 * @author Kukharonok Andrey
 */
public interface ICommunicationPrinter {

    /**
     * Метод возвращает сообщение для данного человека
     * @param name Имя человека
     * @return сообщение для данного человека
     */
    String welcom(String name);
}
