package com.codeclan.example.courseBooking.controllers;

import com.codeclan.example.courseBooking.models.Booking;
import com.codeclan.example.courseBooking.repos.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepo bookingRepo;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getRequests(@RequestParam(name = "date", required=false)String date){
        if(date != null){
            return new ResponseEntity<>(bookingRepo.findByDate(date), HttpStatus.OK);
        }
        return new ResponseEntity<>(bookingRepo.findAll(), HttpStatus.OK);
    }

}


