package com.example.demo.service;

import java.util.Optional;

import org.bson.types.ObjectId;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {

    Optional<Student> createStudent(Student student);
    Optional<Student> updateStudentById(ObjectId id,Student student);
    Optional<Student> updateNameById(ObjectId id,String name);
    Optional<Student> updateCityById(ObjectId id,String city);
    Boolean deleteStudentById(ObjectId id);
    Optional<Student> getStudentById(ObjectId id);
    List<Student> getAll();
    Boolean isStudentExist(ObjectId id);
    List<String> getSupportMethods();

}
