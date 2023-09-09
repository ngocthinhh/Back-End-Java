/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.servicies.Impl;

import com.thinh.pojos.Trip;
import com.thinh.repositories.TripRepository;
import com.thinh.servicies.TripService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ngoc Thinh
 */
@Service
public class TripServiceImpl implements TripService{
    @Autowired
    private TripRepository tripRepository;
    
    @Override
    public List<Trip> getTrip() {
        return this.tripRepository.getTrip();
    }

    @Override
    public void addTrip(Trip trip) {
        this.tripRepository.addTrip(trip);
    }

    @Override
    public void deleteTrip(int id) {
        this.tripRepository.deleteTrip(id);
    }

    @Override
    public Trip getTripById(int id) {
        return this.tripRepository.getTripById(id);
    }

    @Override
    public void updateTrip(Trip trip) {
        this.tripRepository.updateTrip(trip);
    }

    @Override
    public List<Trip> getTripByIdUser(int id) {
        return this.tripRepository.getTripByIdUser(id);
    }
    
}
