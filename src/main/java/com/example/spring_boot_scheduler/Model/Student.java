package com.example.spring_boot_scheduler.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String gender;
    private String email;
    private String phone;
    private String address;
    private String course;
    private String status;
    private String collegeName;


    public Student(String name, String gender, String email, String phone, String address, String course, String status, String collegeName) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.course = course;
        this.status = status;
        this.collegeName = collegeName;
    }


}
