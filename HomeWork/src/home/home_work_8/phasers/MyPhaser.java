package home.home_work_8.phasers;

// Расширить класс Phaser и переопределить метод onAdvance()
// таким образом, чтобы было выполнено только определенное
// количество фаз

import java.util.concurrent.*;

// Расширить класс MyPhaser, чтобы выполнить только
// определенное количество фаз

public class MyPhaser extends Phaser {
    int numPhases;

    MyPhaser(int parties, int phaseCount) {
        super(parties);
        this.numPhases = phaseCount - 1;
    }

    // переопределить метод onAdvance(), чтобы выполнить
    // определенное количество фаз

    protected boolean onAdvance(int p, int regParties) {
        // Следующий оператор println() требуется только для
        // целей иллюстрации. Как правило, метод onAdvance()
        // не отображает выводимые данные
        System.out.println("Фаза " + p + " завершена.\n");

        // возратить логическое значение true,если все фазы завершены
        // В противном случает возратить логическое значение false;
        return p == this.numPhases || regParties == 0;
    }
}
