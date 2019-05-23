package com.bookingsystem.booking.repository.BookingRepository;

import com.bookingsystem.booking.models.Booking;

import java.util.List;

public interface BookingRepositoryCustom {
    List<Booking> findBookingsByDate(String date);

}
