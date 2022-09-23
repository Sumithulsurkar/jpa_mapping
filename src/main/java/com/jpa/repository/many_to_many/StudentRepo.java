package com.jpa.repository.many_to_many;

import com.jpa.model.many_to_many.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {

        List<Student> findByNameContaining(String name); // findBy -> pre fix, Name -> 'Containing' keyword which is equivalent to 'LIKE' expression.
}
