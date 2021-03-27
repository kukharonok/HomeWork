package home.home_work_9.utils;

import java.io.*;

public class Utils {

   private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String acceptRequestConsole() {
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
}
