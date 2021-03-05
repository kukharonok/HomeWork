package home.home_work_4.containers;

import java.util.*;

public class DataContainer<T> implements Iterable<T> {

    /**
     * Количество элементов, которые содержит список. null не учитываются
     */
    private int size;

    /**
     * Количество элементов, которые содержит список с учетом пустых значений null,
     * если список был создан на основе массива обьектов
     */
    private int sizeWithNull;

    /**
     * Начальная емкость по умолчанию.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Буфер массива, в котором хранятся элементы DataContainer. Емкость DataContainer - это длина этого буфера массива
     */
    private T[] data;

    /**
     * Создает пустой список с начальной емкостью на 10 элементов
     */
    public DataContainer() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Создает пустой список с заданной начальной емкостью.
     *
     * @param capacity начальная емкость списка
     *                 Throws: IllegalArgumentException – если заданный начальный размер контейнера отрицательный
     */
    public DataContainer(int capacity) {
        if (capacity >= 0) {
            this.data = (T[]) new Object[capacity];
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Создает список, содержащий элементы указанного массива
     * Элементы могут быть null
     *
     * @param elements массив, элементы которого должны быть помещены в этот список
     */
    public DataContainer(T[] elements) {
        this.data = elements;
        int count = 0;
        for (T datum : elements) {
            if (datum != null) {
                count++;
            }
        }
        this.size = count;
        this.sizeWithNull = elements.length;
    }

    /**
     * Возвращает текущий массив обьектов списка
     *
     * @return текущий массив элементов
     */
    public T[] getItems() {
        return this.data;
    }

    /**
     * Возвращает текущее количество элементов в списке
     *
     * @return текущее количество элементов в списке, которые не null
     */
    public int getSize() {
        return size;
    }

    /**
     * Возвращает текущее количество элементов в списке вместе с null,
     * если они были добавлены в список через массив элементов
     * (Метод для тестирования)
     *
     * @return текущее количество элементов в списке вместе с null
     */
    public int getSizeWithNull() {
        return sizeWithNull;
    }

    /**
     * Возвращает индекс пустой ячейки с null в списке, есле нет пустых ячеек, то возвращает -1;
     *
     * @return индекс пустой ячейки со значнеием null
     */
    private int findNull() {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Добавляет новый элемент в список. При достижении размера внутреннего
     * массива происходит его увеличение на 1 элемент.При добавлении обьекта возвращается индекс,
     * куда он будет добавлен.
     * Добавить обьект null нельзя в список: при добавлении null возвращает -1;
     *
     * @param item добавляемый элемент
     * @return индекс добавляемого элемента; если элемент null - возвращается -1
     */
    public int add(T item) {
        if (item == null) {
            return -1;
        }
        if (size < data.length) {
            int idx = findNull();
            data[idx] = item;
            if (size == sizeWithNull) {
                sizeWithNull++;
            }
            size++;
            return idx;
        }
        if (size == data.length) {
            data = growData();
            int temp = size;
            data[size] = item;
            size++;
            sizeWithNull++;
            return temp;
        }
        return -1;
    }

    /**
     * Выводит в консоль массив обьектов, используя метод класса Arrays
     * (Метод для тестирования)
     *
     * @return строку всех элементов списка текущей емкости
     */
    public void printArray() {
        System.out.println("DataContainer: " + Arrays.toString(data));
    }

    /**
     * Метод для расширения массива на 1 элемент
     *
     * @return новый увеличенный на 1 массив
     */
    private T[] growData() {
        return Arrays.copyOf(data, data.length + 1);
    }

    /**
     * Возвращает элемент списка по индексу, если индекс задан неверно - возвращает null
     *
     * @param index индекс элемента списка
     * @return элемент списка, если индекс задан неверно - возвращает null
     */
    public T get(int index) {
        if (checkIndexExist(index)) {
            return this.data[index];
        }
        return null;
    }

    /**
     * Метод проверяет правильность задания индеска списка
     *
     * @param index индекс списка
     * @return true, если индекс задан верно, в противном случае false
     */
    private boolean checkIndexExist(int index) {
        return index < sizeWithNull && index >= 0;
    }

    /**
     * Вспомогательный метод для сжатия массива
     *
     * @param index индекс элемента который удалится из списка
     */
    private void compressionArray(int index) {
        T[] newData = data;
        data = (T[]) new Object[newData.length - 1];
        System.arraycopy(newData, 0, data, 0, index);
        System.arraycopy(newData, index + 1, data, index, newData.length - index - 1);
    }

    /**
     * Удаляет элемент списка по индексу. Все элементы справа от удаляемого
     * перемещаются на шаг левее.При успешном удалении возвращает true, иначе false
     *
     * @param index индекс удаляемого элемента
     * @return возвращает true при успешном удалении, иначе false
     */
    public boolean delete(int index) {
        if (!checkIndexExist(index)) {
            return false;
        }
        if (this.data[index] != null) {
            size--;
        }
        compressionArray(index);
        sizeWithNull--;
        return true;
    }

    /**
     * Удаляет первое вхождение указанного элемента из этого списка, если он присутствует.
     * Если список не содержит элемента, он остается неизменным.Если в списке есть null,
     * то удалится его первое вхождение.
     * Возвращает true, если этот список успешно удалил элемент,иначе false
     *
     * @param item удаляемый элемент списка
     * @return Возвращает true, если этот список успешно удалил элемент,иначе false
     */
    public boolean delete(T item) {
        int index;
        for (int i = 0; i < sizeWithNull; i++) {
            if (item == null) {
                if (data[i] == null) {
                    index = i;
                    compressionArray(index);
                    sizeWithNull--;
                    return true;
                }
            } else if (item.equals(data[i])) {
                index = i;
                compressionArray(index);
                sizeWithNull--;
                size--;
                return true;
            }
        }
        return false;
    }

    /**
     * Вспомогательный метод для сдвига всех значений null вправо списка, если таковые имеются
     */
    private void shiftNullInArray() {
        if (size < sizeWithNull) {
            T[] newData = data;
            data = (T[]) new Object[newData.length];
            for (int i = 0, j = 0; i < newData.length; i++) {
                if (newData[i] == null) {
                    continue;
                } else {
                    data[j] = newData[i];
                    j++;
                }
            }
        }
    }

    /**
     * Метод  сортирует элементы списка используя реализацию сравнения из ПЕРЕДАННОГО объекта comparator.
     *
     * @param comparator компаратор, используемый для сравнения элементов списка. null значение указывает на то,
     *                   что следует использовать естественный порядок элементов
     */
    public void sort(Comparator<T> comparator) {
        this.shiftNullInArray();
        Arrays.sort(data, 0, size, comparator);
    }

    /**
     * Метод сортирует элементы в ПЕРЕДАННОМ объекте DataContainer используя реализацию сравнения
     * вызываемый у хранимых объектов.
     *
     * @param container переданный список обьектов типа T
     * @param <T>       тип обьектов
     */
    public static <T extends Comparable<T>> void sort(DataContainer<T> container) {
        container.sort((Comparator<T>) null);
        //или еще 2 варианта... дописать
    }

    /**
     * Метод сортирует элементы в ПЕРЕДАННОМ объекте DataContainer используя реализацию сравнения из ПЕРЕДАННОГО
     * объекта DataContainer интерфейса Comparator.
     *
     * @param container  переданный список обьектов типа T
     * @param comparator компаратор, используемый для сравнения элементов списка.
     * @param <T>        тип обьектов
     */
    public static <T> void sort(DataContainer<T> container, Comparator<T> comparator) {
        container.sort(comparator);
    }

    /**
     * выводить содержимое data в консоль без ячеек в которых хранится null.
     *
     * @return строку со значениями обьектов
     */
    @Override
    public String toString() {
        if (data == null) {
            return "null";
        }
        if (data.length == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        boolean comma = false;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                if (comma) {
                    builder.append(", ");
                } else {
                    comma = true;
                }
                builder.append(data[i]);
            }
        }
        builder.append(']');
        return builder.toString();
    }

    /**
     * Возвращает итератор над элементами типа T
     *
     * @return обьект Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new ContainerIterator();
    }

    private class ContainerIterator implements Iterator<T> {

        /**
         * текущий элемент, на который мы смотрим
         */
        int current;

        /**
         * Возвращает true, если итерация содержит больше элементов.
         * (Другими словами, возвращает true, если next вернет элемент, а не вызовет исключение.)
         *
         * @return true, если итерация содержит больше элементов
         */
        @Override
        public boolean hasNext() {
            return current < DataContainer.this.sizeWithNull;
        }

        /**
         * Возвращает следующий элемент итерации и перемещает текущий
         * индекс на следующий элемент.
         *
         * @return следующий элемент в итерации
         * @throws NoSuchElementException если в итерации больше нет элементов
         */
        @Override
        public T next() {
            if (hasNext()) {
                return data[current++];
            } else {
                throw new NoSuchElementException("No more elements");
            }
        }
    }
}
