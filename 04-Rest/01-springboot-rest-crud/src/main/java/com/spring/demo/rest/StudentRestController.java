package com.spring.demo.rest;

import com.spring.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student > theStudents;

    //define @PostConstruct to load the student data
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Pratik","Dhane"));
        theStudents.add(new Student("Prashant","Dheple"));
        theStudents.add(new Student("Shreyash","Tekade"));
    }

    //define endpoint for "/student" return a list of students
    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;
    }

    //define endpoint "/students/{studentId}"- return student at index
    @GetMapping("/students/{studentId}")
   // the path variable and method params must be same
    public Student getStudent(@PathVariable int studentId){

        //Exception logic
        if((studentId>=theStudents.size())||(studentId<0)){
            throw new StudentNotFoundException("Student id not found "+studentId);
        }


        return theStudents.get(studentId);
    }

    //Add an exception handler using @ExceptionHandler
    }










