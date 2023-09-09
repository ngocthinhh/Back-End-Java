/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.controllers;

import com.thinh.pojos.Reservation;
import com.thinh.servicies.ReservationService;
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
public class ApiReservationController {
    @Autowired
    private ReservationService reservationService;
    
    @GetMapping("/reservation")
    public ResponseEntity<List<Reservation>> getAllReservation() {
        return new ResponseEntity<>(this.reservationService.getReservation(), HttpStatus.OK);
    }

    @GetMapping("/reservation/{id}")
    public ResponseEntity<Reservation> getReservationByID(@PathVariable int id) {
        Reservation reservation = this.reservationService.getReservationById(id);

        if (reservation != null) {
            return new ResponseEntity<>(reservation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/reservation/add")
    public ResponseEntity<List<Reservation>> addReservation(@RequestBody Reservation newReservation) {
        Reservation reservation = new Reservation();
        reservation = newReservation;
        reservation.setIdReservation(-1);
        this.reservationService.addReservation(reservation);

        return new ResponseEntity<>(this.reservationService.getReservation(), HttpStatus.CREATED);
    }

    @PutMapping("/reservation/update/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable int id, @RequestBody Reservation updateReservation) {

        try {
            Reservation reservation = this.reservationService.getReservationById(id);

            // PHẢI THAM CHIẾU NHƯ VẬY
            reservation.setIdUserReservation(updateReservation.getIdUserReservation());
            reservation.setIdTripReservation(updateReservation.getIdTripReservation());
            reservation.setTimeReservation(updateReservation.getTimeReservation());
            reservation.setNumberSeatReservation(updateReservation.getNumberSeatReservation());
            
            this.reservationService.updateReservation(reservation);

            return new ResponseEntity<>(reservation, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/reservation/delete/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable int id) {
        this.reservationService.deleteReservation(id);
        return new ResponseEntity<>("Xoá thành công!", HttpStatus.OK);
    }
}
