package com.jpa.repository.many_to_many;

import com.jpa.model.many_to_many.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course, Long> {

    List<Course> findByFeeLessThan(Double fee); // prefix -> findBy + Fee -> data member + Less Than -> condition
}
