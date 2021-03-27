package home.home_work_9;

public class ApplicationMain {

    public static void main(String[] args) {

        String folder = null;
        try {
            folder = (args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Не введены данные");
            e.printStackTrace();
            return;
        }

        LogFile logFile = new LogFile(folder);
        logFile.start();
    }
}



