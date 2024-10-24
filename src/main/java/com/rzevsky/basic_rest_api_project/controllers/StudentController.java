package com.rzevsky.basic_rest_api_project.controllers;

import com.rzevsky.basic_rest_api_project.models.Student;
import com.rzevsky.basic_rest_api_project.service.StudentService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor // инициализация бина через не явный @Autowired
public class StudentController {
//    private List<Student> students = new ArrayList<>();
    public StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public String addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return "Student added successfully!";
    }

    // Создание болванчиков через GET запрос и JS скрипт
    @GetMapping("/initialize1") // /api/students/initialize1
    public String initialize1Students() {
        studentService.addStudent(Student.builder().name("Get Ini Script").email("getiniscript1@example.com").build());
        return "<script>window.location.replace('/');</script>"; // Отдает js скрипт на фронт, заставляя вернуться на http://localhost:8080
    }

    // Создание болванчиков через GET запрос и ResponseEntity
    @GetMapping("/initialize2")
    public ResponseEntity<Void> initialize2Students() {
        studentService.addStudent(Student.builder().name("Get Response Entity").email("getresponseentity1@example.com").build());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/"));
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }
}