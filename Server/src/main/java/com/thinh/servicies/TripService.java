/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.servicies;

import com.thinh.pojos.Trip;
import java.util.List;

/**
 *
 * @author Ngoc Thinh
 */
public interface TripService {
    List<Trip> getTrip();

    void addTrip(Trip trip);

    void deleteTrip(int id);

    Trip getTripById(int id);

    void updateTrip(Trip trip);
    
    List<Trip> getTripByIdUser(int id);
}
