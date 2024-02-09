package com.dev.kali.apiservice.controller;


import com.dev.kali.apiservice.dtos.Students;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class ApiController {

    @GetMapping
    public ResponseEntity<List<Students>> getStudents () {

        List<Students> students = new ArrayList<>();

        Students student1 = new Students();
        student1.setId(1);
        student1.setName("Emmanuel Kinoti");
        student1.setSex("Male");
        student1.setAge(38);

        Students student2 = new Students();
        student2.setId(2);
        student2.setName("Swety Kava");
        student2.setSex("Female");
        student2.setAge(15);

        students.add(student1);
        students.add(student2);

        return ResponseEntity.ok(students);

    }

}
