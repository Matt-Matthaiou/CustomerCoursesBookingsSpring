package com.codeclan.example.courseBooking.controllers;

import com.codeclan.example.courseBooking.models.Course;
import com.codeclan.example.courseBooking.repos.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.lang.Integer.valueOf;

@RestController
public class CourseController {

    @Autowired
    CourseRepo courseRepo;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getCourseRequests(@RequestParam(name="rating", required=false)String rating){
        if(rating != null){
            int parsedRating = valueOf(rating);
            return new ResponseEntity<>(courseRepo.findByRating(parsedRating), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepo.findAll(), HttpStatus.OK);
    }
}
