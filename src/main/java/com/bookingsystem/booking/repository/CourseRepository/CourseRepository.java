package com.bookingsystem.booking.repository.CourseRepository;

import com.bookingsystem.booking.models.Course;
import com.bookingsystem.booking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long>, CourseRepositoryCustom {

    List<Course> findCoursesByStarRating(int starRating);

    List<Course> findCoursesByCustomer(Customer customer);
}
