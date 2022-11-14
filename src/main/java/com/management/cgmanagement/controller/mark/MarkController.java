package com.management.cgmanagement.controller.mark;

import com.management.cgmanagement.model.dto.IMark;
import com.management.cgmanagement.model.dto.IStudent;
import com.management.cgmanagement.model.entity.Course;
import com.management.cgmanagement.model.entity.Mark;
import com.management.cgmanagement.model.entity.User;
import com.management.cgmanagement.service.course.CourseService;
import com.management.cgmanagement.service.mark.MarkService;
import com.management.cgmanagement.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/mark")
public class
MarkController {
    @Autowired
    MarkService markService;

    @Autowired
    UserService userService;

    @Autowired
    CourseService courseService;

    @GetMapping("/findAll")
    public ResponseEntity<Iterable<IMark>> findAllMark() {
        Iterable<IMark> marks = markService.getMarkNative();
        return new ResponseEntity<>(marks, HttpStatus.OK);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<Iterable<IMark>> findMarkById(@PathVariable Long id) {
        Iterable<IMark> marks = markService.getMark1Native(id);
        return new ResponseEntity<>(marks, HttpStatus.OK);
    }
    @GetMapping("/findStudent")
    public ResponseEntity<Iterable<IStudent>> findAllStudent() {
        Iterable<IStudent> students = markService.getStudent();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Mark> save(@RequestBody Mark mark) {
        Mark temp = new Mark();
        temp.setId(mark.getId());

        Long userid = (mark.getUser()).getId();
        Long courseid = (mark.getCourse()).getId();

        User user = userService.findById(userid).get();
        temp.setUser(user);

        Course course = courseService.findById(courseid).get();
        temp.setCourse(course);
        temp.setLecture(mark.getLecture());
        temp.setTutorial(mark.getTutorial());
        temp.setGPA(mark.gpa(mark.getLecture(), mark.getTutorial()));


        return new ResponseEntity<>(markService.save(temp), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Mark> updateCourse(@PathVariable Long id, @RequestBody Mark mark) {
        Optional<Mark> mark1 = markService.findById(id);
        if (!mark1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        mark.setId(mark1.get().getId());
        return new ResponseEntity<>(markService.save(mark), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Mark> deleteCourse(@PathVariable Long id) {
        Optional<Mark> mark = markService.findById(id);
        if (!mark.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        markService.remove(id);
        return new ResponseEntity<>(mark.get(), HttpStatus.OK);
    }
}
