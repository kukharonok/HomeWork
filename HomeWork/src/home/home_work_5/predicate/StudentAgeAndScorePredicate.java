package home.home_work_5.predicate;

import home.home_work_5.dto.Student;

import java.util.function.Predicate;

public class StudentAgeAndScorePredicate implements Predicate<Student> {

    private final int age;
    private final int score;

    public StudentAgeAndScorePredicate(int age, int score) {
        this.age = age;
        this.score = score;
    }

    @Override
    public boolean test(Student student) {
        return student.getAge() >= age && student.getScore() > score;
    }
}
