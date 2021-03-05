package home.home_work_5.random;

import home.home_work_5.random.api.IRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class NameRandom extends BasicRandom implements IRandom {

    List<String> nameList;

    public NameRandom(List<String> nameList) {
        this.nameList = nameList;
    }

    @Override
    public String randString(int min, int max) {
        int lengthName = ThreadLocalRandom.current().nextInt(min, max);
        List<String> nameListTemp = new ArrayList<>();
        for (String s : nameList) {
            if (s.length() == lengthName) {
                nameListTemp.add(s);
            }
        }
        return nameListTemp.get(ThreadLocalRandom.current().nextInt(nameListTemp.size()));
    }
}

