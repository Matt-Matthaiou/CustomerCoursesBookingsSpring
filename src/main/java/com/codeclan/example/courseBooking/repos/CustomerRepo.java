package com.codeclan.example.courseBooking.repos;

import com.codeclan.example.courseBooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
