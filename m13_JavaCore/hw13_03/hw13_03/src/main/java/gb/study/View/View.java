package gb.study.View;

import gb.study.Model.Employee;

import java.util.ArrayList;

/**
 * Представление для отображения данных
 */
public class View {

    /**
     * Вывод данных о сотрудниках
     * @param employees список сотрудников
     * @return таблица в виде строки с данными о сотрудниках
     */
    public static String employeePrint(ArrayList<Employee> employees) {
        StringBuilder names = new StringBuilder();
        names.append("Фамилия\t\tИмя\t\tПаспорт\t\tДолжность\t\tДпата рождения\t\tЗарплата\n");
        for (Employee employee : employees) {
            names.append(employee.getFirstName()).append("\t\t").
                  append(employee.getLastName()).append("\t\t").
                  append(employee.getPassport()).append("\t\t").
                  append(employee.getPost()).append("\t\t").
                  append(         (employee.getBirthDate().getDate() + 1990)
                          + "." + (employee.getBirthDate().getMonth())
                          + "." + (employee.getBirthDate().getDate())).append("\t\t").
                  append(employee.getSalary()).append("\n");
        }
        return names.toString();
    }
}
