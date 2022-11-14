package com.management.cgmanagement.repository;

import com.management.cgmanagement.model.entity.Course;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CourseRepository extends PagingAndSortingRepository<Course,Long> {
}
