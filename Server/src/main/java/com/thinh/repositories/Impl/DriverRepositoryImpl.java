/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.repositories.Impl;

import com.thinh.pojos.Driver;
import com.thinh.repositories.DriverRepository;
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
public class DriverRepositoryImpl implements DriverRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Driver> getDriver() {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Driver");
        return q.getResultList();
    }

    @Override
    public void addDriver(Driver driver) {
        Session session = sessionFactory.getObject().getCurrentSession();

        session.save(driver);
    }

    @Override
    public void deleteDriver(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        Driver driverDelete = session.get(Driver.class, id);

        if (driverDelete != null) {
            session.delete(driverDelete);
        }
    }

    @Override
    public Driver getDriverById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        Driver driver = session.get(Driver.class, id);
        return driver;
    }

    @Override
    public void updateDriver(Driver driver) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        session.update(driver);
    }
    
}
