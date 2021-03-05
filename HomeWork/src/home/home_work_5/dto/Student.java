package home.home_work_5.dto;

import java.util.Objects;

public class Student {

    private final int id;
    private final String name;
    private final int age;
    private final double score;
    private final boolean olympic;

    public Student(int id, String name, int age, double score, boolean olympic) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
        this.olympic = olympic;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getScore() {
        return score;
    }

    public boolean isOlympic() {
        return olympic;
    }

    @Override
    public String toString() {
        return String.format("Student { id= %d name= %s age= %d score= %.3f olympic= %s }",
                id, name, age, score, olympic);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && age == student.age && Double.compare(student.score, score) == 0
                    && olympic == student.olympic && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, score, olympic);
    }
}
