package home.home_work_9.utils;

import java.io.*;

public class Utils {

    public static String acceptRequestConsole() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = null;
        try {
            text = reader.readLine();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return text;
    }

    public static void printListFiles(File[] listFiles) {
        for (File fileIn : listFiles) {
            System.out.println(fileIn.getName());
        }
    }

    public static File getNameOfBook(File[] listFiles, String nameOfBook) {
        File name = null;
        for (File temp : listFiles) {
            if (temp.getName().equals(nameOfBook)) {
                name = temp;
            }
        }
        return name;
    }

    public static void writeToFile(String s, File fileResult) {
        try (FileWriter writer = new FileWriter(fileResult, fileResult.exists())) {
            writer.write(s);
            writer.flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
