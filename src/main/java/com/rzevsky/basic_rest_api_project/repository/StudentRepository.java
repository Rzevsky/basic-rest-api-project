package com.rzevsky.basic_rest_api_project.repository;

import com.rzevsky.basic_rest_api_project.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
