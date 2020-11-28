package com.sb.ioc.di;

import java.util.List;
import java.util.Set;

public class School {
    private String name;
    private Set<Teacher> teachers;
    private Set<Student> students;
    private List<CourseSet> courseSets;
    
    public School() {
    }

    public School(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public List<CourseSet> getCourseSets() {
        return courseSets;
    }

    public void setCourseSets(List<CourseSet> courseSets) {
        this.courseSets = courseSets;
    }

    @Override
    public String toString() {
        return "School{" + "name=" + name + ", teachers=" + teachers + ", students=" + students + ", courseSets=" + courseSets + '}';
    }
    
}
