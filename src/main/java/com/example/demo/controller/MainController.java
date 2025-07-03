package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api")
public class MainController {


    @Autowired
    private StudentService studentService;

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") ObjectId id)
    {
        // return student.isPresent() ? 
        //         ResponseEntity.ok(student.get()) : ResponseEntity.notFound().build();
        return studentService.getStudentById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> students = studentService.getAll();
        // &&students!=null no need to check this
        return (!students.isEmpty()) ? 
                ResponseEntity.ok(students) :ResponseEntity.noContent().build();
    }

    @PostMapping("/students")
    public ResponseEntity<Student> insertStudent(@RequestBody Student student) {
        Optional<Student> student2 = studentService.createStudent(student);
        return student2.isPresent()?
                ResponseEntity.status(HttpStatus.CREATED).body(student2.get()):
                ResponseEntity.notFound().build();
    }

    @PutMapping("students/{id}")
    public ResponseEntity<Student> updateStudent(
                                @PathVariable ObjectId id,@RequestBody Student student) {
        Optional<Student> student2 = studentService.updateStudentById(id, student);
        return student2.isPresent() ?
                ResponseEntity.ok(student2.get()):
                ResponseEntity.notFound().build();
    }
    
    // Single entity come with formatted string not as json obj so
    @PatchMapping("/students/{id}/name")
    public ResponseEntity<Student> updateStudentNameById(
                                @PathVariable ObjectId id,@RequestBody Map<String, String> request)
    {
        String name = request.get("name");
        Optional<Student> student = studentService.updateNameById(id, name);
        return student.isPresent() ?
                ResponseEntity.ok(student.get()):
                ResponseEntity.notFound().build(); 
    }

     @PatchMapping("/students/{id}/city")
    public ResponseEntity<Student> updateStudentCityById(
                                @PathVariable ObjectId id,@RequestBody Map<String, String> request)
    {
        String city = request.get("city");
        Optional<Student> student = studentService.updateCityById(id, city);
        return student.isPresent() ?
                ResponseEntity.ok(student.get()):
                ResponseEntity.notFound().build(); 
    }

    
    @RequestMapping(value = "/students/{id}", method=RequestMethod.HEAD)
    public ResponseEntity<Void> isStudentExist(@PathVariable ObjectId id) {
        boolean isStudentExist = studentService.isStudentExist(id);
        return isStudentExist ? 
                                ResponseEntity.ok().build() :
                                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable ObjectId id)
    {
        boolean isStudentExist = studentService.deleteStudentById(id);
        return isStudentExist ? 
                                ResponseEntity.noContent().build() :
                                ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/students", method=RequestMethod.OPTIONS)
    public ResponseEntity<List<String>> isStudentExist() {
        return ResponseEntity.ok(studentService.getSupportMethods());
    }
    
}
