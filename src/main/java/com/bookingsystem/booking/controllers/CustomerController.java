package com.bookingsystem.booking.controllers;


import com.bookingsystem.booking.models.Customer;
import com.bookingsystem.booking.repository.BookingRepository.BookingRepository;
import com.bookingsystem.booking.repository.CourseRepository.CourseRepository;
import com.bookingsystem.booking.repository.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/{course}")
    public List<Customer> findCustomersByCourse(String course){
        return customerRepository.findCustomersByCourse(course);
    }
}
