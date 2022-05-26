package com.codeclan.example.courseBooking.repos;

import com.codeclan.example.courseBooking.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course, Long> {

    List<Course> findByRating(int rating);
}
