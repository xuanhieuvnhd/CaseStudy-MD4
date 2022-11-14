package com.management.cgmanagement.service.tuition;

import com.management.cgmanagement.model.dto.ITuition;
import com.management.cgmanagement.model.entity.Tuition;
import com.management.cgmanagement.repository.TuitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TuitionService implements ITuitionService {

    @Autowired
    private TuitionRepository tuitionRepository;

//    @Override
//    public Iterable<Tuition> findAll() {
//        return tuitionRepository.findAll();
//    }

    @Override
    public Optional<Tuition> findById(Long id) {
        return tuitionRepository.findById(id);
    }



    @Override
    public Tuition save(Tuition tuition) {
        return tuitionRepository.save(tuition);
    }

    @Override
    public void remove(Long id) {
        tuitionRepository.deleteById(id);
    }

    @Override
    public Page<Tuition> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.tuitionRepository.findAll(pageable);
    }
    @Override
    public Iterable<ITuition> getTuitionNative() {
        return tuitionRepository.getTuitionNative();
    }
}
