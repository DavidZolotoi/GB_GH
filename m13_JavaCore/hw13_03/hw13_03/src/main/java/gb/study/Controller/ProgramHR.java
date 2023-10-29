package gb.study.Controller;

import gb.study.Model.Employee;
import gb.study.Model.Leader;
import gb.study.View.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/*
    1. Написать прототип компаратора - метод внутри класса сотрудника, сравнивающий две даты,
    представленные в виде трёх чисел гггг-мм-дд, без использования условного оператора.
    2. Опишите класс руководителя, наследник от сотрудника.
    Перенесите статический метод повышения зарплаты в класс руководителя, модифицируйте метод таким образом,
    чтобы он мог поднять заработную плату всем, кроме руководителей.
    В основной программе создайте руководителя и поместите его в общий массив сотрудников.
    Повысьте зарплату всем сотрудникам и проследите, чтобы зарплата руководителя не повысилась.
*/

/**
 * Инструментарий сотрудника HR - Контроллер программы
 */
public class ProgramHR {
    public static void main(String[] args) {

        // получение данных о принятых на сегодня сотрудниках (в идеале из БД, но для этой задачи из стат.коллекции)
        ArrayList<Employee> employees = Employee.getEmployees();

        // добавление сотрудников конструктором, принимающим серию и номер паспорта, должность, Фамилию, Имя и дату рождения
        employees.add(new Employee("123456", Employee.Post.ENGINEER1, "Иван", "Иванов", new Date(1994, 4, 4), 50000));
        employees.add(new Employee("234567", Employee.Post.ENGINEER2, "Сергей", "Сергеев", new Date(1995, 5, 5), 40000));
        employees.add(new Employee("345678", Employee.Post.LEADER, "Петр", "Петров", new Date(1993, 3, 3), 100000));
        employees.add(new Employee("456789", Employee.Post.DIRECTOR, "Алексей", "Алексов", new Date(1991, 1, 1), 500000));
        employees.add(new Employee("567890", Employee.Post.DIR_DEPUTY, "Андрей", "Андреев", new Date(1992, 2, 2), 300000));

        System.out.println("Начальный список сотрудников:\n" +
                View.employeePrint(employees)
        );

        // сортировка по дате рождения с использованием компаратора и вложенного класса
        Collections.sort(employees, (new Employee()).new TheComparator());

        System.out.println("Отсортированный список сотрудников с использованием компаратора и вложенного класса:\n" +
                View.employeePrint(employees)
        );

        // повышение зарплаты (кем) новым руководителем (кому) всем сотрудникам, не руководительской должности
        Leader leader = new Leader("678901", Employee.Post.LEADER, "Михаил", "Янов", new Date(1997, 7, 7), 100000);
        employees.add(leader);
        employees = leader.salaryWorkerIncrease(employees, 15);

        System.out.println("Зарплаты после повышения:\n" +
                View.employeePrint(employees)
        );

    }

}