/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.repositories.Impl;

import com.thinh.pojos.User;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.thinh.repositories.UserRepository;

/**
 *
 * @author Ngoc Thinh
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<User> getUser() {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM User");
        return q.getResultList();
    }
    
    @Override
    public List<User> getUsersByRole(String role) {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM User WHERE role_user=:role");
        q.setParameter("role", role);
        List results = q.getResultList();
        return results;
    }
    
    @Override
    public User getUserByUsername(String username) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM User WHERE username_user=:un");
        q.setParameter("un", username);
        List results = q.getResultList();
        if (results.isEmpty()) {
            return null;
        }
        return (User) results.get(0);
    }
    
    @Override
    public boolean isHaveUserByUsername(String username) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM User WHERE username_user=:un");
        q.setParameter("un", username);
        List results = q.getResultList();
        if (results.isEmpty()) {
            return false;
        }
        return true;
    }
    
    @Override
    public int countUser() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        
        Query q = s.createQuery("SELECT COUNT(*) FROM User");
        return Integer.parseInt(q.getSingleResult().toString());
        
//        Query q = s.createQuery("FROM User");
//        return q.getResultList().size();
    }
    
    @Override
    public boolean addUser(User user) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        
        s.save(user);
        
        return true;
    }
    
    @Override
    public void deleteUser(int id)
    {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        
//        User userDelete = getUserById(id);
        
        User userDelete = s.get(User.class, id);
        
        if (userDelete != null)
        {
            s.delete(userDelete);
        }
    }
    
    public User getUserById(int id)
    {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        
        Query q = s.createQuery("FROM User WHERE id_user=:id");
        q.setParameter("id", id);
        List<User> users = q.getResultList();
        
        return users.get(0);
    }
    
    @Override
    public void updateUser(User user, int id)
    {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        
        if (id != -1)
        {
            s.update(user);
        }
    }
    
    @Override
    public boolean addOrUpdateUser(User user)
    {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try {
            if (user.getIdUser() == -1) {
                session.save(user);
            } else {
                
                session.update(user);
                }
            
            return true;
            
        } catch (Exception e) {
            return false;
        }
    }
}
