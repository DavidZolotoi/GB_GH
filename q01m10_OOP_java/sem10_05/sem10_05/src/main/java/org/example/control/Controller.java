package org.example.control;

import org.example.View;
import org.example.model.Student;
import org.example.model.StudyGroup;
import org.example.model.Teacher;
import org.example.service.ServiceStudent;
import org.example.service.ServiceStudyGroup;
import org.example.service.ServiceTeacher;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public Controller() {
        ServiceTeacher serviceTeacher = new ServiceTeacher();
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(serviceTeacher.create());

        ServiceStudent serviceStudent = new ServiceStudent();
        List<Student> studentList = new ArrayList<>();
        studentList.add(serviceStudent.create());
        studentList.add(serviceStudent.create());

        ServiceStudyGroup serviceStudyGroup = new ServiceStudyGroup();
        List<StudyGroup> studyGroupList = new ArrayList<>();
        studyGroupList.add(serviceStudyGroup.create(teacherList.get(0), studentList));

        View view = new View();
        String s = view.view(studentList);
        System.out.println(s);
        s = view.view(teacherList);
        System.out.println(s);
        s = view.view(studyGroupList);
        System.out.println(s);

    }
}
