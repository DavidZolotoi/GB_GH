package gb.study.Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/**
 * Сотрудник
 */
public class Employee {
    /**
     * Должности сотрудников
     */
    public enum Post {
        DIRECTOR,
        DIR_DEPUTY,
        LEADER,
        ENGINEER1,
        ENGINEER2
    }
    /*
      Тут есть три варианта реализации разделения должностей на руководительскую и не руководительскую:
      0. Вариант вводить его при создании объекта сотрудником HR не логично, ведь существует сетка должностей,
      в которой уже давно всё расписано, а значит ее надо использовать.
      1. Ввести новый enum, который полностью повторяет верхнюю часть enum всех должностей
      2. Ввести числовую константу, на которой заканчиваются руководительские должности
      3. Использовать список-лист, который хранит руководительские должности (либо в числах, либо в текстах)
      Для решения этой задачи, я выбрал первый вариант, но если подходить к делу более глобально, то логично,
      что сетку должностей должен изменять сотрудник в каком-то отдельном файле, а не тут в коде.
    */
    /**
     * Руководители должностей
     */
    public enum PostLeader {
        DIRECTOR,
        DIR_DEPUTY,
        LEADER
    }

    //todo стоит переделать под словарь, чтоб потом легче и быстрее было редактировать например ЗП сотрудника
    /**
     * Список сотрудников ("подобие БД")
     */
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }
    public static void setEmployees(ArrayList<Employee> employees) {
        Employee.employees = employees;
    }

    /**
     * Паспорт сотрудника
     */
    private String passport;
    /**
     * Должность сотрудника
     */
    private Post post;
    /**
     * Руководительская ли должность
     */
    private Boolean postIsLeader;
    /**
     * Имя сотрудника
     */
    private String firstName;
    /**
     * Фамилия сотрудника
     */
    private String lastName;
    /**
     * Дата рождения сотрудника
     */
    private Date birthDate;
    /**
     * Зарплата сотрудника
     */
    private int salary;

    public String getPassport() {
        return passport;
    }
    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Post getPost() {
        return post;
    }
    public void setPost(Post post) {
        this.post = post;
    }

    public Boolean getPostIsLeader() {
        return postIsLeader;
    }
    public void setPostIsLeader(Boolean postIsLeader) {
        this.postIsLeader = postIsLeader;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }


    /**
     * Создание сотрудника
     * @param passport - паспорт сотрудника
     * @param post - должность сотрудника
     * @param firstName - имя сотрудника
     * @param lastName - фамилия сотрудника
     * @param birthDate - дата рождения сотрудника
     * @param salary - зарплата сотрудника
     */
    public Employee(String passport, Post post, String firstName, String lastName, Date birthDate, int salary) {
        this.passport = passport;
        this.post = post;
        this.postIsLeader = false;
        for (var postItem : PostLeader.values()) {
            if (post.equals(postItem)) this.postIsLeader = true;
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    /**
     * Создание сотрудника по умолчанию
     */
    public Employee() {
        new Employee("000000", Post.ENGINEER2, "test", "test", new Date(1990, 1, 1), 0);
    }

    /**
     * Вложенный класс-компаратор для реализации сортировки по дате рождения
     */
    public class TheComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee e1, Employee e2) {
            int year1 = e1.getBirthDate().getYear() + 1990; // получаем год
            int month1 = e1.getBirthDate().getMonth(); // получаем месяц
            int day1 = e1.getBirthDate().getDate(); // получаем день
            int year2 = e2.getBirthDate().getYear() + 1990; // получаем год
            int month2 = e2.getBirthDate().getMonth(); // получаем месяц
            int day2 = e2.getBirthDate().getDate(); // получаем день
            return (year1*10000 + month1*100 + day1) - (year2*10000 + month2*100 + day2);
        }
    }
}
