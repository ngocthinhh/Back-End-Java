/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.repositories.Impl;

import com.thinh.pojos.Feedback;
import com.thinh.repositories.FeedbackRepository;
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
public class FeedbackRepositoryImpl implements FeedbackRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Feedback> getFeedback() {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Feedback");
        return q.getResultList();
    }

    @Override
    public void addFeedback(Feedback feedback) {
        Session session = sessionFactory.getObject().getCurrentSession();

        session.save(feedback);
    }

    @Override
    public void deleteFeedback(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        Feedback feedbackDelete = session.get(Feedback.class, id);

        if (feedbackDelete != null) {
            session.delete(feedbackDelete);
        }
    }

    @Override
    public Feedback getFeedbackById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        Feedback feedback = session.get(Feedback.class, id);
        return feedback;
    }

    @Override
    public void updateFeedback(Feedback feedback) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        session.update(feedback);
    }
}
