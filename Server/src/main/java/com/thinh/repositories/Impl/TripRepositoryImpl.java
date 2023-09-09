/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.repositories.Impl;

import com.thinh.pojos.Trip;
import com.thinh.repositories.TripRepository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ngoc Thinh
 */
@Repository
@Transactional
public class TripRepositoryImpl implements TripRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Trip> getTrip() {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Trip");
        return q.getResultList();
    }
    
    @Override
    public List<Trip> getTripByIdUser(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Trip WHERE id_user_trip=:id");
        q.setParameter("id", id);
        List results = q.getResultList();
        return results;
    }

    @Override
    public void addTrip(Trip trip) {
        Session session = sessionFactory.getObject().getCurrentSession();

        session.save(trip);
    }

    @Override
    public void deleteTrip(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        Trip tripDelete = session.get(Trip.class, id);

        if (tripDelete != null) {
            session.delete(tripDelete);
        }
    }

    @Override
    public Trip getTripById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        Trip trip = session.get(Trip.class, id);
        return trip;
    }

    @Override
    public void updateTrip(Trip trip) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        session.update(trip);
    }
    
}
