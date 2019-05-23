package com.bookingsystem.booking.repository.CourseRepository;

import com.bookingsystem.booking.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long>, CourseRepositoryCustom {
}
