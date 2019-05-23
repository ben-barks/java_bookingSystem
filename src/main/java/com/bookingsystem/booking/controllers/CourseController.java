package com.bookingsystem.booking.controllers;


import com.bookingsystem.booking.models.Course;
import com.bookingsystem.booking.repository.BookingRepository.BookingRepository;
import com.bookingsystem.booking.repository.CourseRepository.CourseRepository;
import com.bookingsystem.booking.repository.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/{starRating}")
    public List<Course> findCoursesByStarRating(@PathVariable int starRating) {
        return courseRepository.findCoursesByStarRating(starRating);
    }
}
