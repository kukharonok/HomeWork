package home.home_work_5.random;

import home.home_work_5.random.api.IRandom;
import java.util.concurrent.ThreadLocalRandom;

public class BasicRandom implements IRandom {

    @Override
    public int randInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    @Override
    public double randDouble(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min, max);
    }

    @Override
    public String randString(int min, int max) {
        String cyrillic = "абвгдежзийклмнопрстуфхцчшщъыьэюя";
        int lengthString=cyrillic.length();
        int numberOfLetters = ThreadLocalRandom.current().nextInt(min, max + 1);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= numberOfLetters; i++) {
            int randomSequence = ThreadLocalRandom.current().nextInt(lengthString);
            result.append(cyrillic.charAt(randomSequence));
        }
        return result.toString();
    }

    @Override
    public boolean randBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
