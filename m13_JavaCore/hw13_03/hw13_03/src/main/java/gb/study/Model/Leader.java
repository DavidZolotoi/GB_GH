package gb.study.Model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Сотрудник с руководительской должностью
 */
public class Leader extends Employee {
    /**
     * Создание сотрудника с руководительской должностью
     * @param passport - паспорт
     * @param post - должность
     * @param firstName - имя
     * @param lastName - фамилия
     * @param date - дата рождения
     * @param salary - зарплата
     */
    public Leader(String passport, Post post, String firstName, String lastName, Date date, int salary) {
        super(passport, post, firstName, lastName, date, salary);
    }

    /**
     * Увеличение зарплаты руководителя
     * @param employees - список всех сотрудников
     * @param percent - процент увеличения зарплаты
     * @return employees - список всех сотрудников
     */
    public static ArrayList<Employee> salaryWorkerIncrease(ArrayList<Employee> employees, int percent) {
        for (var employee : employees) {
            try {
                Employee.PostLeader.valueOf(employee.getPost().toString());
                // => employee - имеет руководительскую должность
            } catch (IllegalArgumentException e) {
                // => employee - имеет НЕ руководительскую должность
                employee.setSalary(employee.getSalary() + employee.getSalary() * percent / 100);
            }
        }
        return employees;
    }
}
