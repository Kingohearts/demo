package com.apis.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apis.demo.entity.Student;
import com.apis.demo.exception.StudentNotFoundException;
import com.apis.demo.repository.StudentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Optional<Student> getStudent(Long id) {
        return studentRepository.findById(id);
        //return unwrapStudent(student, id);
          
    };

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    };

    // public void setStudent(Long id, Student student) {

    // };
    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    };

    static Student unwrapStudent(Optional<Student> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new StudentNotFoundException(id);
    }
}
