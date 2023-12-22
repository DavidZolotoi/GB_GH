package gb.study;

import java.time.Duration;
import java.time.LocalDateTime;

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
