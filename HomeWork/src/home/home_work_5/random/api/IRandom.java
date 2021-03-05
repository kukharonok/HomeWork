package home.home_work_5.random.api;

public interface IRandom {
    /**
     * Возвращает ранодом int в заданом промежутке
     * @param min с
     * @param max по
     * @return рандомное число
     */
    int randInt(int min, int max);

    /**
     * Возвращает ранодом double в заданом промежутке
     * @param min с
     * @param max по
     * @return рандомное число
     */
    double randDouble(double min, double max);

    /**
     * Возвращает ранодом String с указанным количеством символов
     * @param min минимальное количество символовом
     * @param max максимальное количество символов
     * @return рандомная строка
     */
    String randString(int min, int max);

    /**
     * Возвращает ранодом Boolean
     * @return рандомное значение
     */
    boolean randBoolean();
}
