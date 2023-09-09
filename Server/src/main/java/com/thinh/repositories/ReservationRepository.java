/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.repositories;

import com.thinh.pojos.Reservation;
import java.util.List;

/**
 *
 * @author Ngoc Thinh
 */
public interface ReservationRepository {
    List<Reservation> getReservation();

    void addReservation(Reservation reservation);

    void deleteReservation(int id);

    Reservation getReservationById(int id);

    void updateReservation(Reservation reservation);
}
