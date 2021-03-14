package home.home_work_8.semaphores;

import java.util.concurrent.Semaphore;

public class Person implements Runnable {

    private final Semaphore sem;

    // поел ли посетитель
    private boolean full = false;

    private final String name;

    public Person(Semaphore sem, String name) {
        this.sem = sem;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            // если посетитель еще не ел
            if (!full) {
                //Запрашиваем у семафора разрешение на выполнение
                sem.acquire();
                System.out.println(name + " садится за стол");

                // посетитель ест
                Thread.sleep(300);
                full = true;
            }
        } catch (InterruptedException e) {
            System.out.println("Что-то пошло не так!");
            e.printStackTrace();
        }
        System.out.println(name + " поел! Он выходит из-за стола");
        sem.release();
        // посетитель ушел, освободив место другим
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
