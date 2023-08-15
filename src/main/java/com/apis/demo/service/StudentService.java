package com.apis.demo.service;

import java.util.Optional;

import com.apis.demo.entity.Student;


public interface StudentService {
    Optional<Student> getStudent(Long id);
    void saveStudent(Student student);
    //void setStudent(Long id,Student student);
    void deleteStudent(Long id);
}
