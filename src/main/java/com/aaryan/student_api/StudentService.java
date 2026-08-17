package com.aaryan.student_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List getAllStudents() {
        return repository.findAll();
    }

    public String addStudent(Student student) {
        repository.save(student);

        return "Student " + student.getName() + " Registered successfully!";
    }

    public String deleteStudent(int id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with ID " + id + " does not exist.");
        }
        repository.deleteById(id);
        return "Student " + id + " removed.";
    }
}
