package com.jpa.controller.many_to_many;


import com.jpa.model.many_to_many.Course;
import com.jpa.model.many_to_many.Student;
import com.jpa.repository.many_to_many.StudentRepo;
import com.jpa.service.many_to_many.CourseService;
import com.jpa.service.many_to_many.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/course")
public class StudentCourseController {
    @Autowired
    StudentService studentService;

    @Autowired
    CourseService courseService;

    @Autowired
    StudentRepo studentRepo;

    public StudentCourseController(StudentService studentService, CourseService courseService, StudentRepo studentRepo) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.studentRepo = studentRepo;
    }

    /**
     * FOR JSON Payload refer std_course.json
     * http://localhost:8080/student/course/saveStudentCourses
     * @param student
     * @return
     */
    @PostMapping("/saveStudentCourses")
    public Student saveStudentWithCourse(@RequestBody Student student){
       return studentService.saveStdAndCourseData(student);
    }

    /**
     * http://localhost:8080/student/course/getStudents
     * @return
     */
    @GetMapping("/getStudents")
    public List<Student> findAllStudents(){
        return studentService.getStdData();
    }

    /**
     * http://localhost:8080/student/course/5
     * @param studentId
     * @return
     */
    @GetMapping("/{studentId}") //
    public Student getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/find/{name}") //http://localhost:8080/student/course/find/sum
    public List<Student> findStudentsContainingByName(@PathVariable String name){
        return studentService.getStdByName(name);
    }

    @GetMapping("/search/{price}") //http://localhost:8080/student/course/search/5000
    public List<Course> findCourseLessThanPrice(@PathVariable double price){
        return courseService.getCourseDataByFees(price);
    }

    @GetMapping("/getCourses") //http://localhost:8080/student/course/getCourses
    public List<Course> getCourses(){
        return courseService.getCoursesData();
    }
}
