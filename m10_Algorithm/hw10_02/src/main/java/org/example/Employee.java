package org.example;

public class Employee {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Переопределенный метод equals. Сравнивает объект на равенство с тем, что передан в параметре
     * @param obj объект для сравнения на равенство с исходным
     * @return true - одинаковые, false - разные
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof Employee){
            Employee employee = (Employee)obj;
            if (employee.name.equals(name) && employee.age == age)
                return true;
        }
        return false;
    }

    /**
     * Переопределенный метод печати информации о сотруднике
     * @return информацию о сотруднике
     */
    @Override
    public String toString() {
        return String.format("%s - %d", name, age);
    }
}
