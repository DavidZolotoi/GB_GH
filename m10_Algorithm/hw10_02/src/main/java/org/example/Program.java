package org.example;

public class Program {

    public static void main(String[] args) {

        // Работа с Синглтон
        Singleton singleton1 = Singleton.getInstance();
        singleton1.setMySetting(12);
        Singleton singleton2 = Singleton.getInstance();
        singleton2.setMySetting(12);

        // Создаем связный список и добавляем в него сотрудников
        LinkedList<Employee> linkedListEmployee = new LinkedList<>();
        linkedListEmployee.addFirst(new Employee("CCC", 43));
        linkedListEmployee.addFirst(new Employee("AAAAA", 25));
        linkedListEmployee.addFirst(new Employee("NNN", 32));
        linkedListEmployee.addFirst(new Employee("EE", 55));
        Employee employee1 = new Employee("AAAAA", 33);
        linkedListEmployee.addFirst(employee1);
        linkedListEmployee.addFirst(new Employee("AAAAA", 45));
        linkedListEmployee.addFirst(new Employee("DDDD", 22));

        System.out.println("-- Имеющийся список: --\n" + linkedListEmployee);

        System.out.println("-- Отсортированный по возрастанию: --");
        linkedListEmployee.sort(new EmployeeComparator(SortType.Ascending));
        System.out.println(linkedListEmployee);

        System.out.println("-- Отсортированный по убыванию: --");
        linkedListEmployee.sort(new EmployeeComparator(SortType.Descending));
        System.out.println(linkedListEmployee);

        System.out.println("-- Поиск сотрудника в связном списке: --");
        LinkedList<Employee>.Node node = linkedListEmployee.contains(employee1);
        if (node != null){
            System.out.println("Элемент найден");
            System.out.println("Значение элемента: " + node.value);
        }
        else{
            System.out.println("Элемент не найден");
        }

        System.out.println("\n-- Удалить сотрудников из начала и конца: --");
        linkedListEmployee.removeFirst();
        linkedListEmployee.removeLast();
        System.out.println(linkedListEmployee);

        System.out.println("\n-- Разворот списка: --");
        linkedListEmployee.reverse();
        System.out.println(linkedListEmployee);

    }

}
