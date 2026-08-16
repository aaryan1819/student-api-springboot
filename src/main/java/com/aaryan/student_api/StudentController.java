package com.aaryan.student_api;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    ArrayList<Student> students = new ArrayList<>();

    @GetMapping
    public ArrayList<Student> getStudents() {
        Student s1 = new Student(101, "Aman");
        Student s2 = new Student(102, "Aaryan");
        Student s3 = new Student(103, "Abhyuday");

        students.add(s1);
        students.add(s2);
        students.add(s3);

        return students;
    }

    @PostMapping
    public String registerStudent(@RequestBody Student newStudent) {
        students.add(newStudent);

        return "Student " + newStudent.getName() + " Registered successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        // Java 8 feature: This cleanly removes the student matching the ID
        students.removeIf(student -> student.getId() == id);
        return "Student " + id + " removed.";
    }

}
