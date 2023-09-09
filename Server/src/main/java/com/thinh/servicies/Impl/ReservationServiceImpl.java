/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.servicies.Impl;

import com.thinh.pojos.Reservation;
import com.thinh.repositories.ReservationRepository;
import com.thinh.servicies.ReservationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ngoc Thinh
 */
@Service
public class ReservationServiceImpl implements ReservationService{
    @Autowired
    private ReservationRepository reservationRepository;
    
    @Override
    public List<Reservation> getReservation() {
        return this.reservationRepository.getReservation();
    }

    @Override
    public void addReservation(Reservation reservation) {
        this.reservationRepository.addReservation(reservation);
    }

    @Override
    public void deleteReservation(int id) {
        this.reservationRepository.deleteReservation(id);
    }

    @Override
    public Reservation getReservationById(int id) {
        return this.reservationRepository.getReservationById(id);
    }

    @Override
    public void updateReservation(Reservation reservation) {
        this.reservationRepository.updateReservation(reservation);
    }
    
}
