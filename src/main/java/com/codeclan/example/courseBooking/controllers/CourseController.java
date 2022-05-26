package com.codeclan.example.courseBooking.controllers;

import com.codeclan.example.courseBooking.models.Course;
import com.codeclan.example.courseBooking.repos.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepo courseRepo;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getCourseRequests(){
        return new ResponseEntity<>(courseRepo.findAll(), HttpStatus.OK);
    }
}
