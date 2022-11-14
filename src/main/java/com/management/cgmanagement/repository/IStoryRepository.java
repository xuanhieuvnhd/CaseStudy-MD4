package com.management.cgmanagement.repository;

import com.management.cgmanagement.model.dto.IStory;
import com.management.cgmanagement.model.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IStoryRepository extends JpaRepository<Story, Long> {
//    Optional<Story> findByName(String content);

//    @Query(nativeQuery = true,value = "insert into story(id,`date`, content, class_id, user_id) values(:id, curdate(), :content, :class_id, :user_id);")
//    void saveNative(@Param("id")Long id,@Param("content")String content, @Param("class_id") Long class_id, @Param("user_id") Long user_id);

    @Query(nativeQuery = true, value = "select  story.content, story.`date`, classes.name_class, users.full_name from story join classes on story.class_id=classes.id \n" +
            "join users on story.user_id =users.id group by story.id;")
 Iterable<IStory> getAllStoryNative();
}
