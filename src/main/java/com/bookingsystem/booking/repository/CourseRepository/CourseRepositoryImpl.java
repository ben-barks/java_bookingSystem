package com.bookingsystem.booking.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class CourseRepositoryImpl implements CourseRepositoryCustom{

    @Autowired
    EntityManager entityManager;
}
