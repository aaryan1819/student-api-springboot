package com.aaryan.student_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired //(@Autowired is Dependency Injection. It tells Spring to automatically plug the database into your controller).
    private StudentRepository repository;

    @GetMapping
    public ArrayList<Student> getStudents() {
        return (ArrayList<Student>) repository.findAll();
    }

    @PostMapping
    public String registerStudent(@RequestBody Student newStudent) {
        repository.save(newStudent);

        return "Student " + newStudent.getName() + " Registered successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        // Java 8 feature: This cleanly removes the student matching the ID
        repository.deleteById(id);
        return "Student " + id + " removed.";
    }

}
