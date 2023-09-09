/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.repositories.Impl;

import com.thinh.pojos.Employee;
import com.thinh.repositories.EmployeeRepository;
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
public class EmployeeRepositoryImpl implements  EmployeeRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Employee> getEmployee() {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Employee");
        return q.getResultList();
    }

    @Override
    public void addEmployee(Employee employee) {
        Session session = sessionFactory.getObject().getCurrentSession();

        session.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        Employee employeeDelete = session.get(Employee.class, id);

        if (employeeDelete != null) {
            session.delete(employeeDelete);
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        session.update(employee);
    }
    
}
