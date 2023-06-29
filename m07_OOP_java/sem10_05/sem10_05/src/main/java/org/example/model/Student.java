package org.example.model;

public class Student extends APeople {
    public Student() {
        super();
    }

    @Override
    public String toString() {
        return "Student "+ super.toString();
    }
}
