package home.home_work_8.semaphores;

import java.util.concurrent.Semaphore;

public class PersonMain {

    public static void main(String[] args) {

        Semaphore sem = new Semaphore(2);
        new Thread(new Person(sem, "Посетитель 1")).start();
        new Thread(new Person(sem, "Посетитель 2")).start();
        new Thread(new Person(sem, "Посетитель 3")).start();
        new Thread(new Person(sem, "Посетитель 4")).start();
        new Thread(new Person(sem, "Посетитель 5")).start();
    }
}
