package com.codeclan.example.courseBooking.repos;

import com.codeclan.example.courseBooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseNameIgnoreCase(String courseName);

    List<Customer> findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(String town, String course);

    List<Customer> findByTownIgnoreCaseAndBookingsCourseNameIgnoreCaseAndAgeGreaterThan(String town, String course, int age);
}
