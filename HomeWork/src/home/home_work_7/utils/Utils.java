package home.home_work_7.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
}
