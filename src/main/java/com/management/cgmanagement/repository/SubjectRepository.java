package com.management.cgmanagement.repository;

import com.management.cgmanagement.model.entity.Subject;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SubjectRepository extends PagingAndSortingRepository<Subject,Long> {
    List<Subject> findByName(String name);
}
