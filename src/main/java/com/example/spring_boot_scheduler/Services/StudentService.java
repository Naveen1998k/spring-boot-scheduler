package com.example.spring_boot_scheduler.Services;

import com.example.spring_boot_scheduler.Model.Student;
import com.example.spring_boot_scheduler.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> saveAllStudents(List<Student> students) {
        return studentRepository.saveAll(students);
    }


}
