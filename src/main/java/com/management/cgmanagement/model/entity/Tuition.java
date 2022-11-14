package com.management.cgmanagement.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="tuition")
public class Tuition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @NotEmpty
    private Double completedFee;
//    @NotEmpty
    private Double totalFee;
    private Double debt;
    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Tuition() {
    }


    public Tuition(Long id, Double completedFee,Double totalFee, Course course) {
        this.id = id;

        this.completedFee = completedFee;
        this.totalFee= totalFee;
        this.course=course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Double getCompletedFee() {
        return completedFee;
    }

    public void setCompletedFee(Double completedFee) {
        this.completedFee = completedFee;
    }

    public Double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Double getDebt() {
        return debt;
    }

    public void setDebt(Double debt) {
        this.debt = debt;
    }

    public Double debt (Double completedFee, Double totalFee){
        Double DEBT = totalFee - completedFee;
        return DEBT;
    }
}