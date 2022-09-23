package com.jpa.model.many_to_many;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "STUDENT_TBL")
public class   Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String dept;

    /* To learn for those who start with spring boot JPA; that's being said I don't find it logical
    to use the "cascade=CascadeType.All" for an @ManyToMany association because by removing one
    student for example the cascade will likely delete the course referenced by that student ignoring
    completely that other students may still reference the same course.
    It's better to use CascadeType.PERSIST and CascadeType.MERGE.*/

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "STUDENT_COURSE_TBL",
    joinColumns = { @JoinColumn(name = "student_id", referencedColumnName = "id")}, // student id
    inverseJoinColumns = { @JoinColumn(name = "course_id", referencedColumnName = "id")}) // Course id
    @JsonBackReference
    private Set<Course> course;

    public Student() {
    }

    public Student(Long id, String name, int age, String dept, Set<Course> course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dept = dept;
        this.course = course;
    }

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

    public Set<Course> getCourse() {
        return course;
    }

    public void setCourses(Set<Course> course) {
        this.course = course;
    }
}
