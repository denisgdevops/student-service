package com.dev.kali.apiservice.service;

import com.dev.kali.apiservice.dtos.Students;
import com.dev.kali.apiservice.model.Tutorial;
import com.dev.kali.apiservice.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiService {

    @Autowired
    TutorialRepository tutorialRepository;


    public List<Tutorial> fetchTutorials (String title) {

        List<Tutorial> tutorials = new ArrayList<Tutorial>();

        if (title == null)
            tutorials.addAll(tutorialRepository.findAll());
        else
            tutorials.addAll(tutorialRepository.findByTitleContaining(title));

        return tutorials;

    }


    public List<Students> fetchStudents () {

        List<Students> students = new ArrayList<>();
        Students student1 = new Students();
        student1.setId(1);
        student1.setName("Emmanuel Keni");
        student1.setSex("Female");
        student1.setAge(38);

        Students student2 = new Students();
        student2.setId(2);
        student2.setName("Swety Kava");
        student2.setSex("Female");
        student2.setAge(15);

        students.add(student1);
        students.add(student2);

        return students;

    }
}
