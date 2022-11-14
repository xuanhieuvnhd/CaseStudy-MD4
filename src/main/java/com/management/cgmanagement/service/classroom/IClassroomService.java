package com.management.cgmanagement.service.classroom;

import com.management.cgmanagement.model.entity.ClassRoom;
import com.management.cgmanagement.model.entity.Course;
import com.management.cgmanagement.repository.ClassRoomRepository;
import com.management.cgmanagement.repository.CourseRepository;
import com.management.cgmanagement.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public interface IClassroomService extends GenericService<ClassRoom> {

}
