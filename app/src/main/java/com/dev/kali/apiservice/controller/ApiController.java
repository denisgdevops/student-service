package com.dev.kali.apiservice.controller;


import com.dev.kali.apiservice.dtos.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class ApiController {

    @Autowired
    ApiService apiService;

    @GetMapping
    public ResponseEntity<List<Students>> getStudents () {
        List<Students> students = apiService.fetchStudents();
        return ResponseEntity.ok(students);

    }

}
