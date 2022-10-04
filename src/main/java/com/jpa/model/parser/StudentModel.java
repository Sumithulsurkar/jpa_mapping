package com.jpa.model.parser;

import java.util.List;

public class StudentModel {

    private Long id;
    private String name;
    private int age;
    private String dept;

    private double totalCourseCost;

    private List<CoursesModel> courses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public double getTotalCourseCost() {
        return totalCourseCost;
    }

    public void setTotalCourseCost(double totalCourseCost) {
        this.totalCourseCost = totalCourseCost;
    }

    public List<CoursesModel> getCourses() {
        return courses;
    }

    public void setCourses(List<CoursesModel> courses) {
        this.courses = courses;
    }
}
