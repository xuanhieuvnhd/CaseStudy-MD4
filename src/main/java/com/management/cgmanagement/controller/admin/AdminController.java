package com.management.cgmanagement.controller.admin;


import com.management.cgmanagement.model.dto.ITuition;
import com.management.cgmanagement.model.entity.ClassRoom;
import com.management.cgmanagement.model.entity.Course;
import com.management.cgmanagement.model.entity.Role;
import com.management.cgmanagement.model.entity.User;
import com.management.cgmanagement.service.course.ICourseService;
import com.management.cgmanagement.service.jwt.TokenService;
import com.management.cgmanagement.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
public class AdminController {
    @Autowired
    TokenService tokenService;

    @Autowired
    ICourseService courseService;

    @Autowired
    IUserService userService;

    @PostMapping("/create-course")
    public ResponseEntity<Course> register(@RequestBody Course course){
        try {
            return new ResponseEntity<>(courseService.save(course), HttpStatus.OK);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @GetMapping("/all-users")
    public ResponseEntity<Iterable<User>> getAllUser(){
        Iterable<User> users = null;
        try {
            users = userService.getUsersNative();
        }
        catch (Exception e){
            e.printStackTrace();
        }
//        if (courses.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
