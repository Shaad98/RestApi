package com.example.demo.service;

import java.util.Optional;
import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {

    Optional<Student> createStudent(Student student);
    Optional<Student> updateStudentById(int id,Student student);
    Optional<Student> updateNameById(int id,String name);
    Optional<Student> updateCityById(int id,String city);
    Boolean deleteStudentById(int id);
    Optional<Student> getStudentById(int id);
    List<Student> getAll();
    Boolean isStudentExist(int id);
    List<String> getSupportMethods();

}
