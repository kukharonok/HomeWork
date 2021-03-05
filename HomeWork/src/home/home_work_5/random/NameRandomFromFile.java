package home.home_work_5.random;

import home.home_work_5.random.api.IRandom;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class NameRandomFromFile extends BasicRandom implements IRandom {

    private final String fileName;

    public NameRandomFromFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String randString(int min, int max) {
        int lengthName = ThreadLocalRandom.current().nextInt(min, max);
        List<String> wordsList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String read;
            while ((read = br.readLine()) != null) {
                if (read.length() == lengthName) {
                    wordsList.add(read);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("I/O error.");
        }
        return wordsList.get(ThreadLocalRandom.current().nextInt(wordsList.size()));
    }
}
