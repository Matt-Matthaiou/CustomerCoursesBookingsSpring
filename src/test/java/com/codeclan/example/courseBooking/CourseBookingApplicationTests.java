package com.codeclan.example.courseBooking;

import com.codeclan.example.courseBooking.models.Course;
import com.codeclan.example.courseBooking.models.Customer;
import com.codeclan.example.courseBooking.repos.BookingRepo;
import com.codeclan.example.courseBooking.repos.CourseRepo;
import com.codeclan.example.courseBooking.repos.CustomerRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CourseBookingApplicationTests {

	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	BookingRepo bookingRepo;
	@Autowired
	CourseRepo  courseRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void canGetCoursesWithGivenRating(){
		List<Course> courseList = courseRepo.findByRating(5);
		assertEquals(1, courseList.size());
	}

	@Test
	public void canGetAllCustomersOnAGivenCourse(){
		List<Customer> customerList = customerRepo.findByBookingsCourseName("Unity");
		assertEquals(2, customerList.size());
	}

}
