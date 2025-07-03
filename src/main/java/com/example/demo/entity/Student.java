package com.example.demo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

// @Entity
// @Table(name = "students")

@Document(collection = "students")
public class Student {
    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    // private int id;
    private ObjectId objectId;
    private String name;
    private String city;
}
