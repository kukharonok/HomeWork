package home.hanoy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TowerOfHanoiMain {

    private String name;
    private int numberOfRings; // число дисков
    private int core;  //количество стержней
    private int gameMode;
    private int numOfStep; // число шагов
    private int[][] array;
    private int freeIdx;// индекс самой нижней свободной ячейки
    private int diskIdx; //индекс самой верхней ячейки где есть диск

    public static void main(String[] args) {

        TowerOfHanoiMain game = new TowerOfHanoiMain();
        game.setUpGame();
        if (game.gameMode == 1) {
            game.startPlayingManual();
        } else if (game.gameMode == 2) {
            game.startPlayingAutomatic();
        } else {
            System.out.println("Неправильно введены данные.");
            return;
        }
    }

    private void moveDisk(int[][] towers, int fromIdx, int toIdx) {
        int temp;
        temp = towers[this.diskIdx][fromIdx];
        towers[this.diskIdx][fromIdx] = 0;
        towers[this.freeIdx][toIdx] = temp;
    }

    private boolean checkGameOver(int[][] array) {
        if (array[0][this.core - 1] == 1) {
            System.out.println("Вы успешно закончили игру за количество ходов: " + this.numOfStep);
            return false;
        }
        return true;
    }

    private boolean checkPrompt(int[][] array, int from, int to) { //проверка на возможность хода
        int diskIdxTo = 0;
        this.numOfStep++;
        if (from < 0 || from > (this.core - 1) || to < 0 || to > (this.core - 1)) {
            return false;
        }
        if (array[array.length - 1][from] == 0) {
            return false;  //стержень пустой - проверка не прошла
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i][from] > 0) {
                this.diskIdx = i;  //находим индекс самой верхней ячейки где есть диск который будем брать
                break;
            }
        }
        if (array[array.length - 1][to] == 0) {
            this.freeIdx = array.length - 1;// если нет дисков то свободная самая нижняя ячейка
            return true;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i][to] > 0) {
                this.freeIdx = i - 1;//находим индекс самой нижней свободной ячейки
                diskIdxTo = i;
                break;
            }
        }
        if (array[diskIdxTo][to] > array[this.diskIdx][from]) {
            return true;
        }
        return false;
    }

    private void setUpGame() {
        try {
            System.out.print("Выберите режим игры: 1 - ручной, 2 - автоматический: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            this.gameMode = Integer.parseInt(reader.readLine());
            System.out.print("Введите количество стержней в диапазоне [3 до 8]: ");
            this.core = Integer.parseInt(reader.readLine());
            System.out.print("Введите количество колец в диапазоне [3 до 20]: ");
            this.numberOfRings = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException ex) {
            System.out.println(ex.toString());
            ex.printStackTrace();
        }
        System.out.println("Цель этой игры состоит в том, чтобы перенести пирамиду из колец " +
                "за наименьшее число ходов на крайний правый стержень.\n За один раз разрешается переносить только" +
                " одно кольцо, причём нельзя класть большее кольцо на меньшее. Удачи!");

        this.array = new int[this.numberOfRings][this.core];
        for (int i = 0; i < this.numberOfRings; i++) {
            array[i][0] = i + 1;
        }
    }

    private void displayGameField(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] > 0) {
                    System.out.print(array[i][j] + "    ");
                } else {
                    System.out.print("*    ");
                }
            }
            System.out.println();
        }
        System.out.println("----------------");
    }

    private void startPlayingManual() {
        System.out.println("Ручной режим игры: ");
        System.out.println("Наша башня: ");
        displayGameField(this.array);
        System.out.println("Начинаем игру:");
        boolean b = start();
        if (!b) {
            gameOver();
        }
    }

    private boolean start() {
        int from;
        int to;
        while (true) {
            from = getUserInput("Взять диск из ");
            if (from == -1) {
                return false;
            }
            to = getUserInput("Положить диск в ");
            if (to == -1) {
                return false;
            }
            if (checkPrompt(array, from, to)) {
                moveDisk(array, from, to);
                displayGameField(array);
                if (!(checkGameOver(array))) {
                    return false;
                }
            } else {
                System.out.println("К сожалению данный ход не возможен правилами игры, выберите другой ход.");
                return start();
            }
        }
    }

    private void startPlayingAutomatic() {
        System.out.println("Автоматический режим игры ");
    }

    private void gameOver() {
        setName();
        System.out.println("Конец игры");
    }

    private void setName() {
        System.out.print("Введите имя сохранения: ");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            this.name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getUserInput(String prompt) {
        System.out.print(prompt);
        int temp = 0;
        String s = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            s = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (s.equals("exit")) {
            return -1;
        } else {
            try {
                temp = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return temp;
    }
}


