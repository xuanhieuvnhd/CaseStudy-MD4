package com.management.cgmanagement.repository;

import com.management.cgmanagement.model.entity.Story;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StoryRepository extends PagingAndSortingRepository<Story,Long> {
}
