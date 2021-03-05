package home.home_work_2.loops;

/**
 * 1.4.* Умножать число long a = 1; пока не произойдёт переполнение. В конце в консоль вывести сообщение со значением
 * до переполнения и после переполнения. Умножать на:
 * 1.4.1. 3
 * 1.4.2. 188
 * 1.4.3. -19
 * 1.4.4. Да и вообще на любое целочисленное
 */

public class LoopsTask1_4 {

    public static String multiplyToOverflow(int b) {
        String s = null;
        long a = 1;
        boolean overflowMarker = true;
        long result = 1;
        long bAbs = Math.abs(b);
        while (overflowMarker) {
            long aAbs = Math.abs(a);
            result = a * b;
            if (((aAbs | bAbs) >>> 31 != 0)) {
                // Некоторые биты больше 2^31, которые могут вызвать переполнение
                // Проверьте результат с помощью оператора divide
                if ((b != 0) && (result / b != a)) {
                    overflowMarker = false;
                    s = "before overflow: " + a + "; ";
                }
            }
            a = result;
        }
        return s + "after overflow: " + result;
    }
}

