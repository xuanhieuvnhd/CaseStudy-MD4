package com.management.cgmanagement.controller.classroom;

import com.management.cgmanagement.model.entity.ClassRoom;
import com.management.cgmanagement.service.classroom.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/classes")
public class ClassroomController {
    @Autowired
    private IClassroomService classroomService;
    @GetMapping
    public ResponseEntity<Iterable<ClassRoom>> findAllClassRoom(){
        List<ClassRoom> classRooms= (List<ClassRoom>) classroomService.findAll();
        if(classRooms.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(classRooms, HttpStatus.OK);
    }
}
