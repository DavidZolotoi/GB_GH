package org.example;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

    private SortType sortType;

    /**
     * Компаратор для сравнения сотрудников
     * @param sortType перечисление: Ascending или Descending
     */
    public EmployeeComparator(SortType sortType) {
        this.sortType = sortType;
    }

    /**
     * Метод компаратора для сравнения 2х объектов (по имени и по возрасту)
     * @param o1 первый объект для сравнения
     * @param o2 второй объект для сравнения
     * @return результат сравнения (-1, 0 или 1)
     */
    @Override
    public int compare(Employee o1, Employee o2) {
        int nameRes = (sortType == SortType.Ascending) ?
                o1.getName().compareTo(o2.getName()) :  // вернет -1, 0 или 1
                o2.getName().compareTo(o1.getName());   // вернет -1, 0 или 1
        if (nameRes == 0){
            return (sortType == SortType.Ascending) ?
                    Integer.compare(o1.getAge(), o2.getAge()) :
                    Integer.compare(o2.getAge(), o1.getAge());
        }
        return nameRes;
    }
}
