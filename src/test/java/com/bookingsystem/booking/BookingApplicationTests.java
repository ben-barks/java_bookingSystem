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
		Course ruby = new Course("Ruby", "Inverness", 4);
		courseRepository.save(ruby);

		Customer jenn = new Customer("Jenn", "Edinburgh", 27);
		customerRepository.save(jenn);

		Booking booking3 = new Booking("20-04-2019", ruby, jenn);
		bookingRepository.save(booking3);

		List<Customer> found = customerRepository.findCustomersByCourse(ruby);
		assertEquals(1, found.size());
		assertEquals("Jenn", found.get(0).getName());
	}

	@Test
	public void canGetCoursesByCustomer(){
		Course ruby = new Course("Ruby", "Inverness", 4);
		courseRepository.save(ruby);

		Customer jenn = new Customer("Jenn", "Edinburgh", 27);
		customerRepository.save(jenn);

		Booking booking3 = new Booking("20-04-2019", ruby, jenn);
		bookingRepository.save(booking3);

		List<Course> found = courseRepository.findCoursesByCustomer(jenn);
		assertEquals(1, found.size());
		assertEquals("Ruby", found.get(0).getName());
	}

	@Test
	public void canGetBookingsByDate(){
		Course ruby = new Course("Ruby", "Inverness", 4);
		courseRepository.save(ruby);

		Course java = new Course("Java", "Edinburgh", 5);
		courseRepository.save(java);

		Customer jenn = new Customer("Jenn", "Edinburgh", 27);
		customerRepository.save(jenn);

		Customer alasdair = new Customer("Alasdair", "Dunfirmlane", 29);
		customerRepository.save(alasdair);

		Booking booking1 = new Booking("20-04-2019", ruby, alasdair);
		bookingRepository.save(booking1);

		Booking booking2 = new Booking("21-04-2019", java, jenn);
		bookingRepository.save(booking2);

		Booking booking3 = new Booking("20-04-2019", ruby, jenn);
		bookingRepository.save(booking3);

		Booking booking4 = new Booking("21-04-2019", java, alasdair);
		bookingRepository.save(booking4);

		List<Booking> found = bookingRepository.findBookingsByDate("21-04-2019");
		assertEquals(2, found.size());
		assertEquals(booking2, found.get(0));
	}

}
