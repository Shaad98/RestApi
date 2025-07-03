package com.example.demo.service.implementation;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import org.springframework.util.ObjectUtils;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{


    @Autowired
    private StudentRepository studentRepository;

    // saveStudent 
    @Override
    public Optional<Student> createStudent(Student student) {
        Student student2 = studentRepository.save(student);
        return Optional.ofNullable(student2);
    }

    // updateStudent 
    @Override
    public Optional<Student> updateStudentById(ObjectId id,Student student) {
        Student student2 = studentRepository.findById(id).orElse(null);
        // if(student2==null) return Optional.ofNullable(student2);
        if(student2==null) return Optional.empty();
        // Student student3 = studentRepository.save(student);
        student2.setCity(
            student.getCity()!=null ? student.getCity() : student2.getCity()
        );
        student2.setName(
            student.getName()!=null ? student.getName() : student2.getName()
        );
        // return Optional.ofNullable(studentRepository.save(student2));
       return Optional.of(studentRepository.save(student2));

    }

    @Override
    public Optional<Student> updateNameById(ObjectId id, String name) {
       Student student = studentRepository.findById(id).orElse(null);
    //    if(student==null) return Optional.ofNullable(student);
        if(student==null) return Optional.empty();
       student.setName(name);
    //    return Optional.ofNullable(studentRepository.save(student));
       return Optional.of(studentRepository.save(student));

    }

    @Override
    public Optional<Student> updateCityById(ObjectId id, String city) {
       Student student = studentRepository.findById(id).orElse(null);
    //    if(student==null) return Optional.ofNullable(student);
        if(student==null) return Optional.empty();
       student.setCity(city);
    //    Never return null save method
    //    return Optional.ofNullable(studentRepository.save(student));
       return Optional.of(studentRepository.save(student));
    }

    @Override
    public Boolean deleteStudentById(ObjectId id) {
        Student student = studentRepository.findById(id).orElse(null);
        if(student==null) return false;
        studentRepository.delete(student);
        return true;
    }

    @Override
    public Optional<Student> getStudentById(ObjectId id) {
        Student student = studentRepository.findById(id).orElse(null);
        // if(student==null) return Optional.ofNullable(student);
        return Optional.ofNullable(student);
    }

    // getAllStudents 
    @Override
    public List<Student> getAll() {
       List<Student> students = studentRepository.findAll();
       return students;
    }

    // existsById 
    @Override
    public Boolean isStudentExist(ObjectId id) {
        // Student student = studentRepository.findById(id).orElse(null);
        // return student == null ? false : true;
        return studentRepository.existsById(id);
    }

    @Override
    public List<String> getSupportMethods() {
        return List.of("GET","POST","PUT","DELETE","PATCH","HEAD");
    }
}
