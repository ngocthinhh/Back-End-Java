/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.controllers;

import com.thinh.pojos.Trip;
import com.thinh.servicies.RouteService;
import com.thinh.servicies.TripService;
import com.thinh.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Ngoc Thinh
 */
@Controller
public class TripController {
    @Autowired
    TripService tripService;
    
    @Autowired
    UserService userService;
    
    @Autowired
    RouteService routeService;
    
    // GET LIST
    @GetMapping("/listTrip")
    public String getAll(Model model) {
        model.addAttribute("trips", this.tripService.getTrip());

        return "listTrip";
    }
    //
    
    @GetMapping("/trip")
    public String showAdd(Model model) {
        Trip trip = new Trip();
        trip.setIdTrip(-1);

        model.addAttribute("trip", trip);
        model.addAttribute("users", this.userService.getUsersByRole("DRIVER"));
        model.addAttribute("routes", this.routeService.getRoute());

        return "trip";
    }
    
    @GetMapping("/trip/{id}")
    public String showUpdate(Model model, @PathVariable(value = "id") int id) {

        Trip trip = this.tripService.getTripById(id);
        model.addAttribute("trip", trip);
        model.addAttribute("users", this.userService.getUsersByRole("DRIVER"));
        model.addAttribute("routes", this.routeService.getRoute());

        return "trip";
    }
    
    @PostMapping("/trip")
    public String addOrUpdate(Model model, @ModelAttribute(value = "trip") Trip trip) {

        try {
            if (trip.getIdTrip() == -1)
            {
                this.tripService.addTrip(trip);
            }
            else
            {
                this.tripService.updateTrip(trip);
            }
            
            model.addAttribute("trips", this.tripService.getTrip());
            return "listTrip";
        } catch (Exception ex) {
            return "trip";
        }
    }
    
    @GetMapping("/trip/delete/{id}")
    public String deleteTrip(@PathVariable(value = "id") String id, Model model) {
        String msg = "non";

        if (id != null) {
            this.tripService.deleteTrip(Integer.parseInt(id));
            msg = "Xoa thanh cong";
        } else {
            msg = "Khong co id";
        }

        model.addAttribute("trips", this.tripService.getTrip());

        return "listTrip";
    }
}
