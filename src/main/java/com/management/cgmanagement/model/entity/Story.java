package com.management.cgmanagement.model.entity;

import com.management.cgmanagement.model.entity.ClassRoom;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;


@Entity
@Data
@Table(name = "story")
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @NotEmpty
    private Date date;
    @NotEmpty
    private String content;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassRoom classRoom;

    @ManyToOne
    @JoinColumn(name = "user_id")
private User user;
    public Story() {
    }

    public Story(Long id, java.sql.Date  date, String content, ClassRoom classRoom, User user) {
        this.id = id;
        this.date = date;
        this.content = content;
        this.classRoom = classRoom;
        this.user = user;
    }

    public Story(Long id,java.sql.Date  date, String content, ClassRoom classRoom) {
        this.id = id;
        this.date = date;
        this.content = content;
        this.classRoom = classRoom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.sql.Date  getDate() {
        return date;
    }

    public void setDate( java.sql.Date  date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public Story(Date date, String content, ClassRoom classRoom) {
        this.date = date;
        this.content = content;
        this.classRoom = classRoom;

    }
}


