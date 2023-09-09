/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.servicies;

import com.thinh.pojos.Feedback;
import java.util.List;

/**
 *
 * @author Ngoc Thinh
 */
public interface FeedbackService {
    List<Feedback> getFeedback();

    void addFeedback(Feedback feedback);

    void deleteFeedback(int id);

    Feedback getFeedbackById(int id);

    void updateFeedback(Feedback feedback);
}
