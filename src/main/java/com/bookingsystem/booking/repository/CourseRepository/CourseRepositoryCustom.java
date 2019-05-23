package com.bookingsystem.booking.repository.CourseRepository;

import com.bookingsystem.booking.models.Course;

import java.util.List;

public interface CourseRepositoryCustom {

    List<Course> findCoursesByStarRating(int starRating);

}
