package com.myaqa;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public class Students {
    private Collection<Student> students;
    public Students() {
        this.students = Arrays.asList(
                new Student("Дмитрий", 17, Gender.MAN),
                new Student("Максим", 20, Gender.MAN),
                new Student("Екатерина", 20, Gender.WOMAN),
                new Student("Михаил", 28, Gender.MAN)
        );
    }

    private enum Gender {
        MAN,
        WOMAN
    }

    private static class Student {
        private final String name;
        private final Integer age;
        private final Gender gender;

        public Student(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Gender getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return  "(Имя: " + name + ", " +
                    "Возраст: " + age + ", " +
                    "Пол: " + gender + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (!(o instanceof Student)) {
                return false;
            }

            Student student = (Student) o;

            return Objects.equals(name, student.name) &&
                    Objects.equals(age, student.age) &&
                    Objects.equals(gender, student.gender);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, gender);
        }

    }

    public double getAverageAgeOfMaleStudents() {
        return students.stream()
                .filter(student -> student.getGender() == Gender.MAN)
                .mapToInt(Student::getAge)
                .average()
                .orElse(0.0);
    }

    public Collection<Student> getDraftEligibleStudents() {
        return students.stream()
                .filter(student -> student.getGender() == Gender.MAN && isDraftEligible(student.getAge()))
                .collect(Collectors.toList());
    }

    public void printDraftEligibleStudents() {
        Collection<Student> draftEligibleStudents = getDraftEligibleStudents();

        for (Student student : draftEligibleStudents) {
            System.out.println(student);
        }
    }

    private boolean isDraftEligible(int age) {
        return age >= 18 && age <= 27;
    }
}