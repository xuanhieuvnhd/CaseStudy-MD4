package com.management.cgmanagement.service.mark;

import com.management.cgmanagement.model.dto.IMark;
import com.management.cgmanagement.model.dto.IStudent;
import com.management.cgmanagement.model.entity.Mark;
import com.management.cgmanagement.service.GenericService;

import java.util.Optional;

public interface IMarkService  {
//    Mark saveMark(Double lecture, Double tutorial, Long course_id, Long user_id);
    Iterable<IMark> getMarkNative();
    Iterable<IMark> getMark1Native(Long id);
    Iterable<IStudent> getStudent();
    Optional<Mark> findById(Long id);
    Mark save(Mark mark );
    void remove(Long id);

}
