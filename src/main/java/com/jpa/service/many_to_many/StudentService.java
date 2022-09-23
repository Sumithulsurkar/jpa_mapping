package com.jpa.service.many_to_many;

import com.jpa.model.many_to_many.Student;
import com.jpa.repository.many_to_many.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public Student saveStdAndCourseData(Student student){
      return studentRepo.save(student);
    }

    public List<Student> getStdData(){
        return studentRepo.findAll();
    }

    public Student getStudentById(Long studentId){
        return studentRepo.findById(studentId).orElse(null);
    }

    public List<Student> getStdByName(String name){
       return studentRepo.findByNameContaining(name);
    }
}
