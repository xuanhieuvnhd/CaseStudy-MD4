package com.management.cgmanagement.controller.tuition;


import com.management.cgmanagement.model.dto.IMark;
import com.management.cgmanagement.model.dto.ITuition;
import com.management.cgmanagement.model.entity.Course;
import com.management.cgmanagement.model.entity.Tuition;
import com.management.cgmanagement.model.entity.Tuition;
import com.management.cgmanagement.model.entity.User;
import com.management.cgmanagement.service.course.CourseService;
import com.management.cgmanagement.service.mark.MarkService;
import com.management.cgmanagement.service.tuition.TuitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/tuition")
public class TuitionController {
    @Autowired
    private TuitionService tuitionService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private MarkService markService;

    @GetMapping("/findtuition")
    public ResponseEntity<Iterable<ITuition>> findAllTuition() {
        Iterable<ITuition> tuitions = null;
        try {
            tuitions = tuitionService.getTuitionNative();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        if (courses.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
        return new ResponseEntity<>(tuitions, HttpStatus.OK);
    }

    @GetMapping("/findMark")
    public ResponseEntity<Iterable<IMark>> findAllMark() {
        Iterable<IMark> marks = markService.getMarkNative();
//        if (courses.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
        return new ResponseEntity<>(marks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tuition> findById(@PathVariable Long id) {
        Optional<Tuition> tuitions = tuitionService.findById(id);
        if (!tuitions.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tuitions.get(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Tuition> save(@RequestBody Tuition tuition) {
        Tuition temp = new Tuition();
        temp.setId(tuition.getId());

        Long courseid = (tuition.getCourse()).getId();

        Course course = courseService.findById(courseid).get();
        temp.setCourse(course);
        temp.setTotalFee(tuition.getTotalFee());
        temp.setCompletedFee(tuition.getCompletedFee());
        temp.setDebt(tuition.debt(tuition.getCompletedFee(), tuition.getTotalFee()));


        return new ResponseEntity<>(tuitionService.save(temp), HttpStatus.CREATED);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<Tuition> updateTuition(@PathVariable Long id, @RequestBody Tuition tuition) {
        Optional<Tuition> tuitionOptional = tuitionService.findById(id);
        if (!tuitionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tuition.setId(tuitionOptional.get().getId());
        return new ResponseEntity<>(tuitionService.save(tuition), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tuition> deleteTuition(@PathVariable Long id) {
        Optional<Tuition> tuitionOptional = tuitionService.findById(id);
        if (!tuitionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tuitionService.remove(id);
        return new ResponseEntity<>(tuitionOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Tuition> page = tuitionService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Tuition> listTuitions = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listTuitions", listTuitions);
        return "index";
    }
}