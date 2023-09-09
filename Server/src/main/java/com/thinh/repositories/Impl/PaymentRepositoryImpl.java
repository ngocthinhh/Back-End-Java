/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.repositories.Impl;

import com.thinh.pojos.Payment;
import com.thinh.repositories.PaymentRepository;
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
public class PaymentRepositoryImpl implements PaymentRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Payment> getPayment() {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Payment");
        return q.getResultList();
    }
    
    @Override
    public List<Payment> getPaymentByIdUser(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Payment WHERE id_user_payment=:id");
        q.setParameter("id", id);
        List results = q.getResultList();
        return results;
    }

    @Override
    public void addPayment(Payment payment) {
        Session session = sessionFactory.getObject().getCurrentSession();

        session.save(payment);
    }

    @Override
    public void deletePayment(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        Payment paymentDelete = session.get(Payment.class, id);

        if (paymentDelete != null) {
            session.delete(paymentDelete);
        }
    }

    @Override
    public Payment getPaymentById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        Payment payment = session.get(Payment.class, id);
        return payment;
    }

    @Override
    public void updatePayment(Payment payment) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        session.update(payment);
    }
}
