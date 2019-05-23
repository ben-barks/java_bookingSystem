package com.bookingsystem.booking.repository.CustomerRepository;

import com.bookingsystem.booking.models.Course;
import com.bookingsystem.booking.models.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {
    List<Customer> findCustomersByCourse(Course course);
}

