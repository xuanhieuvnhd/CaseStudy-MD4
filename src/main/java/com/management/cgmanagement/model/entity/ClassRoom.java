package com.management.cgmanagement.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "classes")
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String nameClass;
    @NotEmpty
    private int numberStudent;




    public ClassRoom() {
    }

    public ClassRoom( String nameClass, int numberStudent) {

        this.nameClass = nameClass;
        this.numberStudent = numberStudent;

    }

    public ClassRoom(Long id, String nameClass, int numberStudent) {
        this.id = id;

        this.nameClass = nameClass;
        this.numberStudent = numberStudent;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public int getNumberStudent() {
        return numberStudent;
    }

    public void setNumberStudent(int numberStudent) {
        this.numberStudent = numberStudent;
    }

}
