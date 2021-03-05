package home.home_work_5;

import home.home_work_5.comparators.*;
import home.home_work_5.random.BasicRandom;
import home.home_work_5.random.NameRandom;
import home.home_work_5.random.NameRandomFromFile;
import home.home_work_5.dto.Student;
import home.home_work_5.predicate.StudentAgeAndScorePredicate;
import home.home_work_5.suppliers.RandomStudentSupplier;
import home.home_work_5.utils.*;
import home.home_work_5.random.api.IRandom;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 1. Создать класс Student с полями
 * 1.1 Порядковый номер (int)
 * 1.2 Имя (Строка размером от 3 до 10 русских символов)
 * 1.3 возраст (7-17)
 * 1.4 оценка(0.0-10.0)
 * 1.5 признак участия в олимпиадах (bool).
 * 2. Создать 10_000 объектов класс Student и поместить в коллекцию. Данные заполняются рандомно.
 * 2.1 Заполнять имя рандомными русскими символами
 * 2.2* Заполнять имя рандомными понятными именами
 * 2.3** Заполнять имя рандомными понятными именами загруженными из файла.
 * 3. Отфильтровать студентов по нескольким признакам. По возрасту (тем кому 12 и выше), по оценке (выше 8).
 * Отфильтрованных студентов поместить в отдельный список. Старый список дожен остаться неизменным.
 * 4. Отсортировать отфильтрованных студентов по имени, от меньшему к большему. Выести топ 10
 * 5. Отсортировать отфильтрованных студентов по оценке, от большего к меньшему. Выести топ 10
 * 6. Отсортировать отфильтрованных студентов по возрасту и оценке одновременно. Вывести топ 10 в каждом возрасте.
 */
public class CollectionsMain {

    public static void main(String[] args) {

        List<String> nameList = Arrays.asList("Том", "Ира", "Леша", "Вася", "Катя", "Антон", "Михаил", "Андрей",
                "Владимир", "Мария", "Николай", "Анастасия", "Маргарита", "Екатерина", "Афанасий", "Никита",
                "Алексей");
        AtomicInteger atomicInteger = new AtomicInteger(0);
        //IRandom rnd = new BasicRandom();
        //IRandom rnd = new NameRandom(nameList);
        IRandom rnd = new NameRandomFromFile("name_rus.txt");
        Supplier<Student> supplier = new RandomStudentSupplier(atomicInteger, rnd);
        Predicate<Student> predicate = new StudentAgeAndScorePredicate(12, 8);
        Comparator<Student> studentNameComparator = new StudentNameComparator();
        Comparator<Student> studentScoreComparator = new StudentScoreComparator();
        Comparator<Student> ageAndScoreComparator =
                new StudentAgeComparator().thenComparing(new StudentScoreComparator());

        List<Student> filteredList = filteredListStudents(10000, supplier, predicate);

        System.out.println("топ 10 студентов отсортированных по имени, от меньшему к большему");
        printSortListStudents(filteredList, 10, studentNameComparator);
        System.out.println("_____________________________________________________________________________________");

        System.out.println("топ 10 студентов отсортированных по оценке, от большего к меньшему.");
        printSortListStudents(filteredList, 10, studentScoreComparator.reversed());
        System.out.println("_____________________________________________________________________________________");

        System.out.println("топ 10 студентов в каждом возрасте, отсортироватнных по возрасту и оценке одновременно.");
        printAgeAndScoreSortListStudents(filteredList, 10, ageAndScoreComparator);
        System.out.println("_____________________________________________________________________________________");
    }

    /**
     * Метод создает список обьектов Student заданным количеством с рандомными значениями
     * и фильтрует по переданному условию
     *
     * @param numberStudent число студентов, которых будем генерировать
     * @param supplier      рандомные значения характеристик студентов
     * @param predicate     условие для фильтрации
     * @return список отфильтрованных студентов
     */
    public static List<Student> filteredListStudents(int numberStudent,
                                                     Supplier<Student> supplier,
                                                     Predicate<Student> predicate) {
        List<Student> data = new ArrayList<>();
        while (data.size() < numberStudent) {
            data.add(supplier.get());
        }
        List<Student> filteredStudent = new ArrayList<>();
        Iterator<Student> iterator = data.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (predicate.test(student)) {
                filteredStudent.add(student);
            }
        }
        return filteredStudent;
    }

    /**
     * Метод выводит в консоль заданное количество отсортированных студентов по заданному условию сортировки
     *
     * @param list       список студентов для сортировки
     * @param topNumber  число студентов которое выведем в консоль
     * @param comparator условие для сортировки
     */
    public static void printSortListStudents(List<Student> list, int topNumber, Comparator<Student> comparator) {
        SortUtils.shakerSort(list, comparator);
        Iterator<Student> iteratorFilter = list.iterator();
        int count = 0;
        while (iteratorFilter.hasNext() && count < topNumber) {
            System.out.println(iteratorFilter.next());
            count++;
        }
    }

    /**
     * Метод выводит в консоль заданное количество студентов в каждом возрасте,
     * отсортироватнных по возрасту и оценке одновременно
     *
     * @param list       список студентов для сортировки
     * @param topNumber  число студентов которое выведем в консоль
     * @param comparator условие для сортировки по возрасту и оценке
     */
    public static void printAgeAndScoreSortListStudents(List<Student> list,
                                                        int topNumber,
                                                        Comparator<Student> comparator) {
        SortUtils.bubbleSort(list, comparator);
        Iterator<Student> iteratorFilter = list.iterator();
        int ageStudentsStart = iteratorFilter.next().getAge();
        int j = 0;
        while (iteratorFilter.hasNext()) {
            Student student = iteratorFilter.next();
            if ((student.getAge() == ageStudentsStart) && j < topNumber) {
                System.out.println(student);
                j++;
                if (j == topNumber) {
                    ageStudentsStart++;
                    j = 0;
                }
            }
        }
    }
}


