package home.home_work_7;

import home.home_work_6.search.RegExSearch;

public class LogFileRepeatedWordsMain {

    public static void main(String[] args) {
        String folder = null;
        try {
            folder = (args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Не введены данные");
            e.printStackTrace();
            return;
        }

        LogFileRepeatedWords logFile = new LogFileRepeatedWords(folder, "result.txt", new RegExSearch());
        logFile.start();
    }
}
