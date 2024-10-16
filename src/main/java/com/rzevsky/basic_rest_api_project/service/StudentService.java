package com.rzevsky.basic_rest_api_project.service;

import com.rzevsky.basic_rest_api_project.models.Student;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student addStudent(Student student);
}
