package com.management.cgmanagement.service.story;

import com.management.cgmanagement.model.dto.IStory;
import com.management.cgmanagement.model.entity.Story;
import com.management.cgmanagement.service.GenericService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IStoryService{
//    Iterable<Story> findAll();
    Optional<Story> findById(Long id);
    Story save(Story story);
Iterable<IStory> getAllStoryNative();
    void remove(Long id);
}
