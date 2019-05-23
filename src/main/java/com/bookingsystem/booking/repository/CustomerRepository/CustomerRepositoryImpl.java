package com.bookingsystem.booking.repository.CustomerRepository;

import com.bookingsystem.booking.models.Booking;
import com.bookingsystem.booking.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom{

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Customer> findCustomersByCourse(String course){
        List<Customer> result = null;
        Session session = entityManager.unwrap(Session.class);
        try{
            Criteria cr = session.createCriteria(Customer.class);
            cr.createAlias("bookings", "bookingAlias");
            cr.add(Restrictions.eq("bookingAlias.course", course));

            result = cr.list();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}
