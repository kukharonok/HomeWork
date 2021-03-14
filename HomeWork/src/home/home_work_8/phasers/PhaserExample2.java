package home.home_work_8.phasers;

import java.util.concurrent.Phaser;

public class PhaserExample2 {

    public static void main(String[] args) {

        MyPhaser myPhaser = new MyPhaser(1, 4);
        System.out.println("Запуск потоков\n");

        new MyThread(myPhaser, "A");
        new MyThread(myPhaser, "B");
        new MyThread(myPhaser, "C");

        // ожидать завершения определенного количества фаз
        while (!myPhaser.isTerminated()) {
            myPhaser.arriveAndAwaitAdvance();
        }

        System.out.println("Синхронизатор фаз завершен");
    }
}

// Поток исполнения, использующий синхронизатор фаз типа Phaser
class MyThread implements Runnable {

    Phaser phaser;
    String name;

    MyThread(Phaser p, String n) {
        this.phaser = p;
        this.name = n;
        this.phaser.register();
        new Thread(this).start();
    }

    public void run() {

        while (!phaser.isTerminated()) {
            System.out.println(
                    "Поток " + name + " начинает фазу " + phaser.getPhase());
            phaser.arriveAndAwaitAdvance();

            // небольшая пауза, чтобы не нарушить порядок вывода.
            // Только для иллюстрации, но необязательно для правильного
            // функционирования синхронизатора фаз

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
