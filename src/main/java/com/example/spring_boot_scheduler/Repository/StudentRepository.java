package com.example.spring_boot_scheduler.Repository;

import com.example.spring_boot_scheduler.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // Additional query methods can be defined here if needed
    // For example, to find students by name:
    // List<Student> findByName(String name);
}
