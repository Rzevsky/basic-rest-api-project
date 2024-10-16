package com.rzevsky.basic_rest_api_project.controllers;

import com.rzevsky.basic_rest_api_project.models.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private List<Student> students = new ArrayList<>();

    @PostConstruct // создание болванчика сразу после инициализации бина
    public void init() {
        students.add(Student.builder().name("Post Construct").email("postconstruct@mail.ee").build());
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }

    @PostMapping
    public String addStudent(@RequestBody Student student) {
        students.add(student);
        return "Student added successfully!";
    }

    // Создание болванчиков через GET запрос и JS скрипт
    @GetMapping("/initialize1") // /api/students/initialize1
    public String initialize1Students() {
        students.add(Student.builder().name("Get Ini Script").email("getiniscript.doe@example.com").build());
        return "<script>window.location.replace('/');</script>"; // Отдает js скрипт на фронт, заставляя вернуться на http://localhost:8080
    }

    // Создание болванчиков через GET запрос и ResponseEntity
    @GetMapping("/initialize2")
    public ResponseEntity<Void> initialize2Students() {
        students.add(Student.builder().name("Get Response Entity").email("getresponseentity@example.com").build());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/"));
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

}