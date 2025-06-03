package com.example.spring_boot_scheduler.Controller;

import com.example.spring_boot_scheduler.Model.Student;
import com.example.spring_boot_scheduler.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private  StudentService studentService;

    @PostMapping("/saveStudent")
    public Student saveStudent( @RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PostMapping("/saveAllStudents")
    public List<Student> saveAllStudents(@RequestBody List<Student> students) {
        return studentService.saveAllStudents(students);
    }
}
