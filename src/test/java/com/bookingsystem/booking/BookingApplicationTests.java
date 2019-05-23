package com.bookingsystem.booking;

import com.bookingsystem.booking.models.Booking;
import com.bookingsystem.booking.models.Course;
import com.bookingsystem.booking.models.Customer;
import com.bookingsystem.booking.repository.BookingRepository.BookingRepository;
import com.bookingsystem.booking.repository.CourseRepository.CourseRepository;
import com.bookingsystem.booking.repository.CustomerRepository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	public void canSaveCourseBookingAndBooking(){
		Course ruby = new Course("Ruby", "Inverness", 4);
		courseRepository.save(ruby);

		Customer jenn = new Customer("Jenn", "Edinburgh", 27);
		customerRepository.save(jenn);

		Booking booking3 = new Booking("20-04-2019", ruby, jenn);
		bookingRepository.save(booking3);
	}

	@Test
	public void canGetCoursesByStarRating(){
		List<Course> found = courseRepository.findCoursesByStarRating(4);
		assertEquals(1, found.size());
		assertEquals("Ruby", found.get(0).getName());
	}

	@Test
	public void canGetCustomersByCourse(){
		List<Customer> found = customerRepository.findCustomersByCourse("Ruby");
		assertEquals(2, found.size());
	}

}
