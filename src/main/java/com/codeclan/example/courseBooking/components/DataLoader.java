package com.codeclan.example.courseBooking.components;

import com.codeclan.example.courseBooking.models.Booking;
import com.codeclan.example.courseBooking.models.Course;
import com.codeclan.example.courseBooking.models.Customer;
import com.codeclan.example.courseBooking.repos.BookingRepo;
import com.codeclan.example.courseBooking.repos.CourseRepo;
import com.codeclan.example.courseBooking.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    CourseRepo courseRepo;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){

        Customer customer1 = new Customer("Bob", "Edinburgh", 50);
        customerRepo.save(customer1);

        Course course1 = new Course("Unity", "Dundee", 5);
        courseRepo.save(course1);

        Course course2 = new Course("Dance", "Glasgow", 4);
        courseRepo.save(course2);

        Course course3 = new Course("Painting", "Linlithgow", 3);
        courseRepo.save(course3);

        Course course4 = new Course("Warhammer", "Edinburgh", 4);
        courseRepo.save(course4);

        Booking booking1 = new Booking("26-02-2022", customer1, course1);
        bookingRepo.save(booking1);


    }
}
