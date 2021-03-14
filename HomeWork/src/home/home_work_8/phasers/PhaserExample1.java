package home.home_work_8.phasers;

import java.util.ArrayList;
import java.util.concurrent.Phaser;

public class PhaserExample1 {

    private static Phaser phaser; // Главный поток

    public static class Passenger implements Runnable {

        /**
         * id пассажира
         */
        int id;
        /**
         * номер станции отправки пассажира
         */
        int departure;

        /**
         * номер станции места назначения (высадки)
         */
        int destination;

        public Passenger(int id, int departure, int destination) {
            this.id = id;
            this.departure = departure;
            this.destination = destination;
            System.out.println(this + " ждёт на станции " + this.departure);
        }

        @Override
        public void run() {
            try {
                System.out.println(this + " вошел в вагон");
                //---------------------------------
                //Пока поезд не приедет на нужную станции назначения(фазу)
                while (phaser.getPhase() < this.destination) {
                    phaser.arriveAndAwaitAdvance();//заявляем в каждой фазе о готовности и ждем
                }
                //---------------------------------
                Thread.sleep(500);
                System.out.println(this + " вышел из вагона");
                //Отменяем регистрацию на нужной станции (фазе)
                phaser.arriveAndDeregister();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "Пассажир " + this.id + " {" + this.departure + " -> " + this.destination + '}';
        }
    }

    public static void main(String[] args) {

        // Регистрация объекта синхронизации
        //Фазы 0 и 6 - это депо метрополитена, 1 - 5 остановки
        phaser = new Phaser(1);

        ArrayList<Passenger> passengers = new ArrayList<>();
        // Формирование списка пассажиров
        for (int i = 1; i < 5; i++) {
            if ((int) (Math.random() * 2) > 0)
                // Этот пассажир проезжает одну станцию
                passengers.add(new Passenger(10 + i, i, i + 1));

            if ((int) (Math.random() * 2) > 0) {
                // Этот пассажир едет до конечной
                passengers.add(new Passenger(20 + i, i, 5));
            }
        }

        // Фазы 0 и 6 - конечные станции
        // Фазы 1...5 - промежуточные станции
        for (int i = 0; i < 7; i++) {
            switch (i) {
                case 0: {
                    System.out.println("Метро вышло из тупика");
                    // Нулевая фаза, участников нет
                    phaser.arrive();//В фазе 0 всего 1 участник - поезд метро
                    break;
                }
                case 6: {
                    // Завершаем синхронизацию
                    System.out.println("Метро ушло в тупик");
                    phaser.arriveAndDeregister(); //Снимаем главный поток, ломаем барьер
                    break;
                }
                default: {
                    int currentStation = phaser.getPhase();
                    System.out.println("Станция " + currentStation);
                    // Проверка наличия пассажиров на станции
                    for (Passenger pass : passengers) {
                        if (pass.departure == currentStation) {
                            // Регистрация участника
                            phaser.register();
                            new Thread(pass).start();
                        }
                    }
                    System.out.println("... открытие дверей ...");

                    // Phaser ожидает завершения фазы всеми участниками
                    phaser.arriveAndAwaitAdvance();
                    System.out.println("... закрытие дверей ...");
                }
            }
        }
    }
}


