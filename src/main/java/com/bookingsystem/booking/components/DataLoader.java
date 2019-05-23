package com.bookingsystem.booking.components;


import com.bookingsystem.booking.models.Booking;
import com.bookingsystem.booking.models.Course;
import com.bookingsystem.booking.models.Customer;
import com.bookingsystem.booking.repository.BookingRepository.BookingRepository;
import com.bookingsystem.booking.repository.CourseRepository.CourseRepository;
import com.bookingsystem.booking.repository.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){
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
    }
}
