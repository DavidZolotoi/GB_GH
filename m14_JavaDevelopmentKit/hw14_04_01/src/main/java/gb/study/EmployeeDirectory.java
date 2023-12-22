package gb.study;

import java.time.Duration;
import java.util.*;

public class EmployeeDirectory implements Iterable{
    LinkedHashMap<Integer, Employee> myMap;

    public EmployeeDirectory() {
        myMap = new LinkedHashMap<>();
    }

    public void add(Employee employee) {
        myMap.put(myMap.size()+1, employee);
    }

    public Employee searchEmployeeByExperience(Duration experience) {
        return myMap.values().stream()
                .sorted(Employee.comparatorByName())
                .filter(value -> value.experience().toDays() == experience.toDays())
                .findFirst().get();
    }

    public Employee searchEmployeeByName(String name) {
        Employee employee = new Employee();
        for (var myValue : myMap.values()) {
            if(myValue.getName().equals(name))
                employee = myValue;
        }
        return employee;
    }

    public Employee searchEmployeeById(Integer id) {
        Employee employee = new Employee();
        for (var myValue : myMap.values()) {
            if(myValue.getId()==id)
                employee = myValue;
        }
        return employee;
    }

    @Override
    public Iterator<Integer> iterator() {
        return myMap.keySet().iterator();
    }
}
