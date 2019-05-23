package com.bookingsystem.booking.repository.CustomerRepository;

import com.bookingsystem.booking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom {
    List<Customer> findCustomersByCourse(String course);
}
