package com.bookingsystem.booking.repository.CourseRepository;

import com.bookingsystem.booking.models.Course;
import com.bookingsystem.booking.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepositoryCustom{

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Course> findCoursesByStarRating(int starRating){
        List<Course> results = null;
        Session session = entityManager.unwrap(Session.class);
        try{
            Criteria cr = session.createCriteria(Course.class);
            cr.add(Restrictions.eq("this.starRating", starRating));
            results = cr.list();
        }
        catch(HibernateException ex){
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return results;
    }

    @Transactional
    public List<Course> findCoursesByCustomer(Customer customer){
        List<Course> result = null;
        Session session = entityManager.unwrap(Session.class);
        try{
            Criteria cr = session.createCriteria(Course.class);
            cr.createAlias("bookings", "bookingAlias");
            cr.add(Restrictions.eq("bookingAlias.customer", customer));

            result = cr.list();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}
