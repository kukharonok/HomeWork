package home.home_work_1;

/**
 * 	4.6 На основании ответа от метода sleepIn вывести сообщение можем спать дальше или пора идти на работу
 *
 * @author Kukharonok  Andrey
 */
public class Task4Main {

    public static void main(String[] args) {

        boolean test = Utils.sleepIn(true, true);
        if (test) {
            System.out.println("Можем спать дальше");
        } else {
            System.out.println("Пора идти на работу");
        }
    }
}

