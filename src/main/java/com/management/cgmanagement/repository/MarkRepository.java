package com.management.cgmanagement.repository;

import com.management.cgmanagement.model.dto.IMark;
import com.management.cgmanagement.model.dto.IStudent;
import com.management.cgmanagement.model.entity.Course;
import com.management.cgmanagement.model.entity.Mark;
import com.management.cgmanagement.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MarkRepository extends JpaRepository<Mark,Long> {
    @Query(nativeQuery = true ,value = "select full_name,lecture,tutorial,gpa from users join mark on `users`.`id` = `mark`.`user_id`;")
    Iterable<IMark> getMarkNative();

    @Query(nativeQuery = true ,value = "select full_name,lecture,tutorial,gpa,mark.user_id from users join mark on `users`.`id` = `mark`.`user_id` where mark.user_id= ?1;")
    Iterable<IMark> getMark1Native(Long id);

    @Query(nativeQuery = true,value = "select `users`.`full_name`,`users`.`date_of_birth`,`users`.`address`,`users`.`email`,`users`.`phone_number`,`classes`.`name_class` from users join user_roles on `users`.`id` = `user_roles`.`role_id` join user_class on `users`.`id` = `user_class`.`user_id` join classes on `user_class`.`class_room_id` = `classes`.`id`  where role_id = 2;")
    Iterable<IStudent> getStudent();
}
