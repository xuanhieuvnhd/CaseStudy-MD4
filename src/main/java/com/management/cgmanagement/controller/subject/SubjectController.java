package com.management.cgmanagement.controller.subject;

import com.management.cgmanagement.model.entity.Course;
import com.management.cgmanagement.model.entity.Mark;
import com.management.cgmanagement.model.entity.Subject;
import com.management.cgmanagement.model.entity.User;
import com.management.cgmanagement.service.course.CourseService;
import com.management.cgmanagement.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    CourseService courseService;

    @GetMapping("/list")
    public ResponseEntity<Iterable<Subject>> findAllSubject(){
        List<Subject> subject = (List<Subject>)subjectService.findAll();
        if (subject.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(subject,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Subject> findById(@PathVariable Long id){
        Optional<Subject> subjects =subjectService.findById(id);
        if (!subjects.isPresent()){
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(subjects.get(),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Subject> save(@RequestBody Subject subject){
        return new ResponseEntity<>(subjectService.save(subject), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable Long id,@RequestBody Subject subject){
        Optional<Subject> subjectOptional = subjectService.findById(id);
        if (!subjectOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        subject.setId(subjectOptional.get().getId());
        return new ResponseEntity<>(subjectService.save(subject),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Subject> deleteSubject(@PathVariable Long id){
        Optional<Subject> subjectOptional = subjectService.findById(id);
        if (!subjectOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        subjectService.remove(id);
        return new ResponseEntity<>(subjectOptional.get(),HttpStatus.OK);
    }
}
