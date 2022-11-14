package com.management.cgmanagement.service.tuition;

import com.management.cgmanagement.model.dto.ITuition;
import com.management.cgmanagement.model.entity.Tuition;
import com.management.cgmanagement.service.GenericService;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ITuitionService {

    Page<Tuition> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
    Iterable<ITuition> getTuitionNative();
    Optional<Tuition> findById(Long id);

    Tuition save(Tuition tuition);

    void remove(Long id);
}

