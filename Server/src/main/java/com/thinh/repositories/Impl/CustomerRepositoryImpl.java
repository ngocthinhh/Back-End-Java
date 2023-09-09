/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.repositories.Impl;

import com.thinh.pojos.Customer;
import com.thinh.repositories.CustomerRepository;
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
public class CustomerRepositoryImpl implements  CustomerRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Customer> getCustomer() {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Customer");
        return q.getResultList();
    }

    @Override
    public void addCustomer(Customer customer) {
        Session session = sessionFactory.getObject().getCurrentSession();

        session.save(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        Customer customerDelete = session.get(Customer.class, id);

        if (customerDelete != null) {
            session.delete(customerDelete);
        }
    }

    @Override
    public Customer getCustomerById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        Customer customer = session.get(Customer.class, id);
        return customer;
    }
    
    @Override
    public Customer getCustomerByUserId(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Customer WHERE id_user_customer=:id_user");
        q.setParameter("id_user", id);
        Customer customer = session.get(Customer.class, id);
        List results = q.getResultList();
        return (Customer) results.get(0);
    }

    @Override
    public void updateCustomer(Customer customer) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        session.update(customer);
    }
}
