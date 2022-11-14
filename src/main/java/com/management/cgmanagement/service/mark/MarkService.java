package com.management.cgmanagement.service.mark;

import com.management.cgmanagement.model.dto.IMark;
import com.management.cgmanagement.model.dto.IStudent;
import com.management.cgmanagement.model.entity.Mark;
import com.management.cgmanagement.repository.MarkRepository;
import com.management.cgmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarkService implements IMarkService{

    @Autowired
    MarkRepository markRepository;
    @Autowired
    UserRepository userRepository;

//    @Override
//    public Iterable<Mark> findAll() {
//        return markRepository.findAll();
//    }

    @Override
    public Iterable<IMark> getMarkNative() {
        return markRepository.getMarkNative();
    }

    @Override
    public Iterable<IMark> getMark1Native(Long id) {
        return markRepository.getMark1Native(id);
    }


    @Override
    public Iterable<IStudent> getStudent() {
        return markRepository.getStudent();
    }

    @Override
    public Optional<Mark> findById(Long id) {
        return markRepository.findById(id);
    }

    @Override
    public Mark save(Mark mark) {
        return markRepository.save(mark);
    }

    @Override
    public void remove(Long id) {
        markRepository.deleteById(id);
    }
}
