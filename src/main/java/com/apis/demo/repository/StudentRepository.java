package com.apis.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.apis.demo.entity.Student;


public interface StudentRepository extends CrudRepository<Student,Long> {

}
