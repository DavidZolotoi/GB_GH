package org.example.model;

import java.util.List;

public class StudyGroup {
    private int id;
    private Teacher teacher;
    private List<Student> studentList;

    public StudyGroup(Teacher teacher, List<Student> studentList) {
        this.id = Index.createId();
        this.teacher = teacher;
        this.studentList = studentList;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "StudyGroup id= "+id+" {" +
                "teacher=" + teacher +
                ", studentList=" + studentList +
                '}';
    }
}