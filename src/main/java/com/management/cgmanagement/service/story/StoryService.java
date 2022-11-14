package com.management.cgmanagement.service.story;

import com.management.cgmanagement.model.dto.IStory;
import com.management.cgmanagement.model.dto.UserPrinciple;
import com.management.cgmanagement.model.entity.Story;
import com.management.cgmanagement.repository.IStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class StoryService implements IStoryService{
    @Autowired
    private IStoryRepository storyRepository;

//    @Override
//    public Iterable<Story> findAll(){
//        return storyRepository.findAll();
//    }

//    @Override
//    public UserDetails loadUserByUsername(String content) throws UsernameNotFoundException {
//        Optional<Story> userOptional = storyRepository.findByName(content);
//        if (userOptional.isPresent()){
//            return UserPrinciple.build(userOptional.get());
//        }
//        return null;
//    }
    @Override
    public Optional<Story> findById(Long id){
        return  storyRepository.findById(id);
    }
    @Override
    public Story save(Story story){
        return storyRepository.save(story);
    }
    @Override
    public  void  remove(Long id){
        storyRepository.deleteById(id);
    }

    @Override
    public Iterable<IStory> getAllStoryNative(){
        return storyRepository.getAllStoryNative();
    }
}
