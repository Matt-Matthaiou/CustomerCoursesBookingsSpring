package com.codeclan.example.courseBooking.repos;

import com.codeclan.example.courseBooking.models.Course;
import com.codeclan.example.courseBooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseName(String courseName);

    List<Customer> findByTownAndBookingsCourseName(String town, String course);

    List<Customer> findByTownAndBookingsCourseNameAndAgeGreaterThan(String town, String course, int age);
}
