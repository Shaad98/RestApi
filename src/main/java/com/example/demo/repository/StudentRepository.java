package com.example.demo.repository;

import org.bson.types.ObjectId;
// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Student;

public interface StudentRepository extends MongoRepository<Student,ObjectId>{

}
