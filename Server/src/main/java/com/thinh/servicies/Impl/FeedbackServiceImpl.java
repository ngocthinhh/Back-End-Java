/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.servicies.Impl;

import com.thinh.pojos.Feedback;
import com.thinh.repositories.FeedbackRepository;
import com.thinh.servicies.FeedbackService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ngoc Thinh
 */
@Service
public class FeedbackServiceImpl implements FeedbackService{
    @Autowired
    private FeedbackRepository FeedbackRepository;
    
    @Override
    public List<Feedback> getFeedback() {
        return this.FeedbackRepository.getFeedback();
    }

    @Override
    public void addFeedback(Feedback feedback) {
        this.FeedbackRepository.addFeedback(feedback);
    }

    @Override
    public void deleteFeedback(int id) {
        this.FeedbackRepository.deleteFeedback(id);
    }

    @Override
    public Feedback getFeedbackById(int id) {
        return this.FeedbackRepository.getFeedbackById(id);
    }

    @Override
    public void updateFeedback(Feedback feedback) {
        this.FeedbackRepository.updateFeedback(feedback);
    }
    
}
