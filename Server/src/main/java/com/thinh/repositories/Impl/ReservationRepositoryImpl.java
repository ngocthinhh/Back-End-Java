/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.repositories.Impl;

import com.thinh.pojos.Reservation;
import com.thinh.repositories.ReservationRepository;
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
public class ReservationRepositoryImpl implements ReservationRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Reservation> getReservation() {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Reservation");
        return q.getResultList();
    }

    @Override
    public void addReservation(Reservation reservation) {
        Session session = sessionFactory.getObject().getCurrentSession();

        session.save(reservation);
    }

    @Override
    public void deleteReservation(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        Reservation reservationDelete = session.get(Reservation.class, id);

        if (reservationDelete != null) {
            session.delete(reservationDelete);
        }
    }

    @Override
    public Reservation getReservationById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        Reservation reservation = session.get(Reservation.class, id);
        return reservation;
    }

    @Override
    public void updateReservation(Reservation reservation) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        session.update(reservation);
    }
    
}
