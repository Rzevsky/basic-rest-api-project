package com.rzevsky.basic_rest_api_project.service;

import com.rzevsky.basic_rest_api_project.models.Student;
import com.rzevsky.basic_rest_api_project.repository.StudentRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    @PostConstruct // создание болванчика сразу после инициализации бина
    private void init() {
        if (studentRepository.count() == 0) {
            studentRepository.save(Student.builder().name("Post Construct").email("postconstruct@mail.ee").build());
        }
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) {
        studentRepository.save(student);
        return student;
    }
}
