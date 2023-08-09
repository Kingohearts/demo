package com.apis.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apis.demo.entity.Student;
import com.apis.demo.repository.StudentRepository;
import com.apis.demo.service.StudentService;


@RequestMapping("/student")
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.getStudent(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<HttpStatus> updateStudentInfo(@PathVariable Long id, @RequestBody Student student) {
    //     studentService.setStudent(id, student);
    //     return new ResponseEntity<>(HttpStatus.OK);
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteStudentInfo(@PathVariable Long id) {
        studentService.deleteStudent(id);        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
