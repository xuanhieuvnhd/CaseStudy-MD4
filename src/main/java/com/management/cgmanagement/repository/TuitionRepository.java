package com.management.cgmanagement.repository;


import com.management.cgmanagement.model.dto.IMark;
import com.management.cgmanagement.model.dto.ITuition;
import com.management.cgmanagement.model.entity.Tuition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TuitionRepository extends JpaRepository<Tuition, Long> {
    @Query(nativeQuery = true ,value = "select `users`.`full_name`,`classes`.`name_class`,`course`.`name`,`tuition`.`completed_fee`, `tuition`.`total_fee`,`tuition`.`debt` from users join user_class on `users`.`id` = `user_class`.`user_id` join classes on `user_class`.`class_room_id` = `classes`.`id` join `course` on `users`.`id` = `course`.`user_id` join `tuition` on `course`.`id` = `tuition`.`course_id`;")
    Iterable<ITuition> getTuitionNative();
}
