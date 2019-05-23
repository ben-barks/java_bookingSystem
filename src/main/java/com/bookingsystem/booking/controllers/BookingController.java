package com.bookingsystem.booking.controllers;


import com.bookingsystem.booking.repository.BookingRepository.BookingRepository;
import com.bookingsystem.booking.repository.CourseRepository.CourseRepository;
import com.bookingsystem.booking.repository.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

}
