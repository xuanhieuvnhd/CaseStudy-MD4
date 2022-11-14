package com.management.cgmanagement.repository;

import com.management.cgmanagement.model.entity.Status;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StatusRepository extends PagingAndSortingRepository<Status,Long> {
}
