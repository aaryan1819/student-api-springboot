package com.aaryan.student_api;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired //(@Autowired is Dependency Injection. It tells Spring to automatically plug the database into your controller).
    private StudentService service;

    @GetMapping
    public List getStudents() {
        return service.getAllStudents();
    }

    @PostMapping
    public String registerStudent(@Valid @RequestBody Student newStudent) {
        return service.addStudent(newStudent);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        // Java 8 feature: This cleanly removes the student matching the ID
        return service.deleteStudent(id);
    }

}
