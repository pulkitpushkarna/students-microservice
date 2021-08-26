package com.kubernetesdemo.studentmicroservice.controller;

import com.kubernetesdemo.studentmicroservice.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    List<Student> studentList = Arrays.asList(
            new Student(1,"student 1",18,"Delhi"),
            new Student(2,"student 2",20,"Mumbai"),
            new Student(3,"student 3",13,"Pune")
    );

    @GetMapping
    public List<Student> students(){
        return studentList;
    }

    @GetMapping("/{id}")
    public Student student(@PathVariable int id){
        Optional<Student> studentOptional=studentList.stream().filter(s->s.getId()==id).findFirst();
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }else{
            return null;
        }
    }

}
