package com.management.cgmanagement.service.classroom;

import com.management.cgmanagement.model.entity.ClassRoom;
import com.management.cgmanagement.model.entity.Course;
import com.management.cgmanagement.repository.ClassRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ClassroomService implements  IClassroomService{
    @Autowired
    ClassRoomRepository classroomRepository;

    @Override
    public Iterable<ClassRoom> findAll() {
        return classroomRepository.findAll();
    }

    @Override
    public Optional<ClassRoom> findById(Long id) {
        return classroomRepository.findById(id);
    }

    @Override
    public ClassRoom save(ClassRoom classRoom) {
        return classroomRepository.save(classRoom);
    }

    @Override
    public void remove(Long id) {
        classroomRepository.deleteById(id);
    }
}
