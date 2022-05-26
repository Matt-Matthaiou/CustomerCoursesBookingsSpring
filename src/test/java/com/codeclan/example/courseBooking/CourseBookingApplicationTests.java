package com.codeclan.example.courseBooking;

import com.codeclan.example.courseBooking.models.Booking;
import com.codeclan.example.courseBooking.models.Course;
import com.codeclan.example.courseBooking.models.Customer;
import com.codeclan.example.courseBooking.repos.BookingRepo;
import com.codeclan.example.courseBooking.repos.CourseRepo;
import com.codeclan.example.courseBooking.repos.CustomerRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
		List<Customer> customerList = customerRepo.findByBookingsCourseNameIgnoreCase("Unity");
		assertEquals(2, customerList.size());
	}

	@Test
	public void canGetCoursesOfSelectedCustomer(){
		List<Course> courses = courseRepo.findByBookingsCustomerNameIgnoreCase("Bob");
		assertEquals(1, courses.size());
	}

	@Test
	public void canGetBookingsByData(){
		List<Booking> bookings = bookingRepo.findByDate("26-02-2022");
		assertEquals(3, bookings.size());
	}

	@Test
	public void canGetCustomersByTownAndCourseName(){
		List<Customer> customers = customerRepo.findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase("Dundee", "Unity");
		assertEquals(2, customers.size());
	}

	@Test
	public void canGetCustomersOverAgeByTownAndCourseName(){
		List<Customer> customers = customerRepo.findByTownIgnoreCaseAndBookingsCourseNameIgnoreCaseAndAgeGreaterThan("Dundee", "Unity", 40);
		assertEquals(1, customers.size());
	}
}
