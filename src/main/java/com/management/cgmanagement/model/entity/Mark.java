package com.management.cgmanagement.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "mark")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double lecture;
    private Double tutorial;
    private Double GPA ;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Double getGPA() {
        return GPA ;
    }

    public void setGPA(Double GPA) {
        this.GPA = GPA;
    }


    public Mark() {
    }

    public Mark(Double lecture, Double tutorial, Double GPA, User user, Course course) {
        this.lecture = lecture;
        this.tutorial = tutorial;
        this.GPA = GPA;
        this.user = user;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLecture() {
        return lecture;
    }

    public void setLecture(Double lecture) {
        this.lecture = lecture;
    }

    public Double getTutorial() {
        return tutorial;
    }

    public void setTutorial(Double tutorial) {
        this.tutorial = tutorial;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Double gpa (Double lecture,Double tutorial){
        Double GPA = (lecture + tutorial)/2;
        return GPA;
    }
}