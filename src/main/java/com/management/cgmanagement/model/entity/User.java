package com.management.cgmanagement.model.entity;



import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name ="users" )
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String fullName;
    private String email;


    private String password;
    private String phoneNumber;
    private String Address;
    private Date dateOfBirth;
    private String identity;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roleSet;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_class", joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "classRoom_id")})
    private Set<ClassRoom> classRooms;

    public User() {
    }

    public User(Long id, String fullName, String email, String password, String phoneNumber, String address, Date dateOfBirth, String identity, Status status, Set<Role> roleSet, Set<ClassRoom> classRooms) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        Address = address;
        this.dateOfBirth = dateOfBirth;
        this.identity = identity;
        this.status = status;
        this.roleSet = roleSet;
        this.classRooms = classRooms;
    }

    public User(String email, String password, Set<Role> roleSet) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    public Set<ClassRoom> getClassRooms() {
        return classRooms;
    }

    public void setClassRooms(Set<ClassRoom> classRooms) {
        this.classRooms = classRooms;
    }
}
