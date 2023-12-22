package gb.study;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;

public class Employee {
    private Integer id;
    private Long phoneNumber;
    private String name;
    private LocalDateTime gotJob;

    public Employee(Integer id, Long phoneNumber, String name, LocalDateTime gotJob) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.gotJob = gotJob;
    }

    public Employee(){}

    protected Duration experience(){
        return Duration.between(LocalDateTime.now(), gotJob);
    }

    public static Comparator<Employee> comparatorByName() {
        return new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        };
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getGotJob() {
        return gotJob;
    }

    public void setGotJob(LocalDateTime gotJob) {
        this.gotJob = gotJob;
    }
}
