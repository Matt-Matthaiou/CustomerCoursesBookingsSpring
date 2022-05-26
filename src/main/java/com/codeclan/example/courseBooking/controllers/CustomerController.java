package com.codeclan.example.courseBooking.controllers;

import com.codeclan.example.courseBooking.models.Customer;
import com.codeclan.example.courseBooking.repos.CourseRepo;
import com.codeclan.example.courseBooking.repos.CustomerRepo;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.lang.Integer.valueOf;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    CourseRepo courseRepo;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getRequests(@RequestParam(name = "courseName", required = false)String courseName,
                                                      @RequestParam(name = "town", required = false)String town,
                                                      @RequestParam(name = "overAge", required = false)String overAge){
        if(courseName != null && town == null){
//
            return new ResponseEntity<>(customerRepo.findByBookingsCourseName(courseName),HttpStatus.OK);
        }
        else if(courseName != null && town != null && overAge == null){
            return new ResponseEntity<>(customerRepo.findByTownAndBookingsCourseName(town, courseName), HttpStatus.OK);
        }
        else if (courseName != null && town != null && overAge != null){
            int parsedAge = valueOf(overAge);
            return new ResponseEntity<>(customerRepo.findByTownAndBookingsCourseNameAndAgeGreaterThan(town, courseName, parsedAge), HttpStatus.OK);
        }

        return new ResponseEntity<>(customerRepo.findAll(), HttpStatus.OK);
    }
}
