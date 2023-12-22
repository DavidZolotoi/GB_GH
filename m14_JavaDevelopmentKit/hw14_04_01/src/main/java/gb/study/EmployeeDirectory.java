package gb.study;

import java.time.Duration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Optional;

public class EmployeeDirectory implements Iterable{
    LinkedHashMap<Integer, Employee> myMap;

    public EmployeeDirectory() {
        myMap = new LinkedHashMap<>();
    }

    public void add(Employee employee) {
        myMap.put(myMap.size()+1, employee);
    }

    public Employee searchEmployeeByExperience(Duration experience) {
//        return myMap.values().stream()
//                .sorted()
//                .filter(value -> value.experience() == experience)
//                .findFirst().get();
        Employee employee = new Employee();
        for (var myValue : myMap.values()) {
            if(myValue.experience().equals(experience))
                employee = myValue;
        }
        return employee;
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
