package com.management.cgmanagement.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name="subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
//    @ManyToOne
//    @JoinColumn(name = "course_id")
//    private Course course;
//    @OneToMany
//    private List<Subject> subjectList;

    public Subject() {
    }

    public Subject(Long id, String name, Course course) {
        this.id = id;
        this.name = name;
//        this.course = course;
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

//    public Course getCourse() {
//        return course;
//    }

//    public void setCourse(Course course) {
//        this.course = course;
//    }
    }
