package com.management.cgmanagement.controller.story;

import com.management.cgmanagement.model.dto.IStory;
import com.management.cgmanagement.model.entity.ClassRoom;
import com.management.cgmanagement.model.entity.Story;
import com.management.cgmanagement.model.entity.User;

import com.management.cgmanagement.service.classroom.IClassroomService;
import com.management.cgmanagement.service.story.IStoryService;
import com.management.cgmanagement.service.user.IUserService;
import com.management.cgmanagement.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Optional;

@RestController
@RequestMapping("/stories")
public class StoryController {


    @Autowired
    private IStoryService storyService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IClassroomService classroomService;

    @GetMapping
    public ResponseEntity<Iterable<IStory>> findAllStory() {
       Iterable<IStory> stories =  storyService.getAllStoryNative();
        return new ResponseEntity<>(stories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Story> findStoryById(@PathVariable Long id) {
        Optional<Story> storyOptional = storyService.findById(id);
        if (!storyOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(storyOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Story> saveStory(@RequestBody Story story) {
       Long millis=System.currentTimeMillis();
        story.setDate(new java.sql.Date(millis));
//Long userID= (story.getUser().getId());
//story.setUser(userService.findById(userID).get());
//Long classID= story.getId();
//story.setClassRoom(classroomService.findById(classID).get());
      try {
          storyService.save(story);
      }
      catch (Exception e){
          e.printStackTrace();
      }
       return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
