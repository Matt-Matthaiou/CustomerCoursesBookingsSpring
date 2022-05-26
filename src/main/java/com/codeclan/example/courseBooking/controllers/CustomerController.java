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

@RestController
public class CustomerController {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    CourseRepo courseRepo;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getRequests(@RequestParam(name = "courseName", required = false)String courseName){
        if(courseName != null){
//
            return new ResponseEntity<>(customerRepo.findByBookingsCourseName(courseName),HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepo.findAll(), HttpStatus.OK);
    }
}
