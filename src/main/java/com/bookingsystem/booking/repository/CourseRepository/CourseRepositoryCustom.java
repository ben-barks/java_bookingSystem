package com.bookingsystem.booking.repository.CourseRepository;

import com.bookingsystem.booking.models.Course;
import com.bookingsystem.booking.models.Customer;

import java.util.List;

public interface CourseRepositoryCustom {

    List<Course> findCoursesByStarRating(int starRating);

    List<Course> findCoursesByCustomer(Customer customer);

}
