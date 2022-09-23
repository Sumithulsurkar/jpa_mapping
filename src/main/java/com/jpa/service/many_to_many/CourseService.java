package com.jpa.service.many_to_many;

import com.jpa.model.many_to_many.Course;
import com.jpa.repository.many_to_many.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepo courseRepo;

    public List<Course> getCoursesData(){
        return courseRepo.findAll();
    }

    public List<Course> getCourseDataByFees(double price){
        return courseRepo.findByFeeLessThan(price);
    }
}
