package com.codeclan.example.courseBooking.repos;

import com.codeclan.example.courseBooking.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, Long> {

    List<Booking> findByDate(String date);
}
