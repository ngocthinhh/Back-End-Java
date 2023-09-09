/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.controllers;

import com.thinh.pojos.Route;
import com.thinh.servicies.RouteService;
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
public class RouteController {
    @Autowired
    private RouteService routeService;
    
    @GetMapping("/listRoute")
    public String getAll(Model model) {
        model.addAttribute("routes", this.routeService.getRoute());

        return "listRoute";
    }
    
    @GetMapping("/route")
    public String showAdd(Model model) {
        Route route = new Route();
        route.setIdRoute("-1");

        model.addAttribute("route", route);

        return "route";
    }
    
    @GetMapping("/route/{id}")
    public String showUpdate(Model model, @PathVariable(value = "id") String id) {

        Route route = this.routeService.getRouteById(id);
        model.addAttribute("route", route);

        return "route";
    }
    
    @PostMapping("/route")
    public String addOrUpdate(Model model, @ModelAttribute(value = "route") Route route) {

        try {
            Route r = this.routeService.getRouteById(route.getIdRoute());
            
            if (r == null)
            {
                this.routeService.addRoute(route);
            }
            else
            {
                this.routeService.updateRoute(route);
            }
            
            model.addAttribute("routes", this.routeService.getRoute());
            return "listRoute";
            
        } catch (Exception ex) {
            return "route";
        }
    }
    
    @GetMapping("/route/delete/{id}")
    public String deleteRoute(@PathVariable(value = "id") String id, Model model) {
        String msg = "non";

        if (id != null) {
            this.routeService.deleteRoute(id);
            msg = "Xoa thanh cong";
        } else {
            msg = "Khong co id";
        }

        model.addAttribute("routes", this.routeService.getRoute());

        return "listRoute";
    }
}
