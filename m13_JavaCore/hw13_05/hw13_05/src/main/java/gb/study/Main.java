package gb.study;

/*
Имеется список студентов. Каждый студент имеет имя, список оценок и специальность.
Найдите первых 5 студентов специальности "Информатика" с средним баллом выше 4.5, отсортированных по убыванию среднего балла.
В решении не использовать циклы! Только StreamAPI
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();

        students.add(new Student("Юрий", new ArrayList<>(Arrays.asList (5.0, 2.0, 5.0, 5.0, 5.0)), "Информатика"));
        students.add(new Student("Маша", new ArrayList<>(Arrays.asList  (2.0, 5.0, 5.0, 5.0, 4.0)), "Информатика"));
        students.add(new Student("Анна", new ArrayList<>(Arrays.asList  (5.0, 5.0, 5.0, 4.0, 3.0)), "Информатика"));
        students.add(new Student("Андрей", new ArrayList<>(Arrays.asList(5.0, 4.0, 2.0, 5.0, 5.0)), "Информатика"));
        students.add(new Student("Иван", new ArrayList<>(Arrays.asList  (5.0, 5.0, 5.0, 4.0, 5.0)), "Информатика"));
        students.add(new Student("Петр", new ArrayList<>(Arrays.asList  (5.0, 5.0, 5.0, 5.0, 5.0)), "Информатика"));
        students.add(new Student("Алексей", new ArrayList<>(Arrays.asList(3.0, 5.0, 5.0, 5.0, 5.0)), "Информатика"));
        students.add(new Student("Александр", new ArrayList<>(Arrays.asList(4.0, 5.0, 5.0, 5.0, 3.0)), "Информатика"));
        students.add(new Student("Сергей", new ArrayList<>(Arrays.asList(5.0, 5.0, 5.0, 2.0, 2.0)), "Информатика"));
        students.add(new Student("Дмитрий", new ArrayList<>(Arrays.asList  (5.0, 5.0, 5.0, 4.0, 5.0)), "Информатика"));
        students.add(new Student("Михаил", new ArrayList<>(Arrays.asList  (5.0, 5.0, 5.0, 5.0, 5.0)), "Информатика"));
        students.add(new Student("Пантелей", new ArrayList<>(Arrays.asList(3.0, 5.0, 5.0, 5.0, 5.0)), "Информатика"));

        // вывод на консоль имен и средних баллов студентов
        students.stream().
                forEach(student -> System.out.println(student.getName() + " " + student.getAverageGrade()));

        System.out.println();

        // получение и вывод решения задачи
        List<Student> result = students.stream().
                filter(student -> student.getSpecialty().equals("Информатика")).
                filter(student -> student.getAverageGrade() > 4.5).
                sorted(Comparator.comparingDouble(Student::getAverageGrade).reversed()).
                limit(5).
                toList();

        result.forEach(student -> System.out.println(student.getName() + " " + student.getAverageGrade()));
    }
}