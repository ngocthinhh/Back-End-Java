/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.controllers;

import com.thinh.pojos.Feedback;
import com.thinh.servicies.FeedbackService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ngoc Thinh
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class ApiFeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    
    @GetMapping("/feedback")
    public ResponseEntity<List<Feedback>> getAllFeedback() {
        return new ResponseEntity<>(this.feedbackService.getFeedback(), HttpStatus.OK);
    }

    @GetMapping("/feedback/{id}")
    public ResponseEntity<Feedback> getFeedbackByID(@PathVariable int id) {
        Feedback feedback = this.feedbackService.getFeedbackById(id);

        if (feedback != null) {
            return new ResponseEntity<>(feedback, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/feedback/add")
    public ResponseEntity<List<Feedback>> addFeedback(@RequestBody Feedback newFeedback) {
        Feedback feedback = new Feedback();
        feedback = newFeedback;
        feedback.setIdFeedback(-1);
        this.feedbackService.addFeedback(feedback);

        return new ResponseEntity<>(this.feedbackService.getFeedback(), HttpStatus.CREATED);
    }

    @PutMapping("/feedback/update/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable int id, @RequestBody Feedback updateFeedback) {

        try {
            Feedback feedback = this.feedbackService.getFeedbackById(id);

            // PHẢI THAM CHIẾU NHƯ VẬY
            feedback.setIdUserFeedback(updateFeedback.getIdUserFeedback());
            feedback.setIdTripFeedback(updateFeedback.getIdTripFeedback());
            feedback.setTextFeedback(updateFeedback.getTextFeedback());
            feedback.setRatingFeedback(updateFeedback.getRatingFeedback());
            
            this.feedbackService.updateFeedback(feedback);

            return new ResponseEntity<>(feedback, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/feedback/delete/{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable int id) {
        this.feedbackService.deleteFeedback(id);
        return new ResponseEntity<>("Xoá thành công!", HttpStatus.OK);
    }
}
