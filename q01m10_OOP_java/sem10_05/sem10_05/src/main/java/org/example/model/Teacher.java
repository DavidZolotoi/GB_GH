package org.example.model;

public class Teacher extends APeople {
    public Teacher() {
        super();
    }

    @Override
    public String toString() {
        return "Teacher "+ super.toString();
    }
}
