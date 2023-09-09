/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.controllers;

import com.thinh.pojos.Trip;
import com.thinh.servicies.TripService;
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
public class ApiTripController {
    @Autowired
    private TripService tripService;
    
    @GetMapping("/trip")
    public ResponseEntity<List<Trip>> getAllTrip() {
        return new ResponseEntity<>(this.tripService.getTrip(), HttpStatus.OK);
    }

    @GetMapping("/trip/{id}")
    public ResponseEntity<Trip> getTripByID(@PathVariable int id) {
        Trip trip = this.tripService.getTripById(id);

        if (trip != null) {
            return new ResponseEntity<>(trip, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/trip/add")
    public ResponseEntity<List<Trip>> addCustomer(@RequestBody Trip newTrip) {
        Trip trip = new Trip();
        trip = newTrip;
        trip.setIdTrip(-1);
        this.tripService.addTrip(trip);

        return new ResponseEntity<>(this.tripService.getTrip(), HttpStatus.CREATED);
    }

    @PutMapping("/trip/update/{id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable int id, @RequestBody Trip updateTrip) {

        try {
            Trip trip = this.tripService.getTripById(id);

            // PHẢI THAM CHIẾU NHƯ VẬY
            trip.setIdRouteTrip(updateTrip.getIdRouteTrip());
            trip.setIdUserTrip(updateTrip.getIdUserTrip());
            trip.setDepartureTimeTrip(updateTrip.getDepartureTimeTrip());
            trip.setPriceTrip(updateTrip.getPriceTrip());
            trip.setNumberSeatsTrip(updateTrip.getNumberSeatsTrip());
            
            this.tripService.updateTrip(trip);

            return new ResponseEntity<>(trip, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/trip/delete/{id}")
    public ResponseEntity<String> deleteTrip(@PathVariable int id) {
        this.tripService.deleteTrip(id);
        return new ResponseEntity<>("Xoá thành công!", HttpStatus.OK);
    }
    
    @GetMapping("/trip/user/{id}")
    public ResponseEntity<List<Trip>> getAllTripByIdUser(@PathVariable int id) {
        return new ResponseEntity<>(this.tripService.getTripByIdUser(id), HttpStatus.OK);
    }
}
