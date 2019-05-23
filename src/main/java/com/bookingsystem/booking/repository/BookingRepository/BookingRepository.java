package com.bookingsystem.booking.repository.BookingRepository;

import com.bookingsystem.booking.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long>, BookingRepositoryCustom {
}
