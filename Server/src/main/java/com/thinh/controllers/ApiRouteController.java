/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.controllers;

import com.thinh.pojos.Route;
import com.thinh.servicies.RouteService;
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
public class ApiRouteController {
    @Autowired
    private RouteService routeService;
    
    @GetMapping("/route")
    public ResponseEntity<List<Route>> getAllRouter() {
        return new ResponseEntity<>(this.routeService.getRoute(), HttpStatus.OK);
    }
    
    @GetMapping("/route/{id}")
    public ResponseEntity<Route> getRouterByID(@PathVariable String id) {
        Route route = this.routeService.getRouteById(id);

        if (route != null) {
            return new ResponseEntity<>(route, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/route/add")
    public ResponseEntity<List<Route>> addRouter(@RequestBody Route newRoute) {
        Route route = new Route();
        route = newRoute;
        this.routeService.addRoute(route);
        return new ResponseEntity<>(this.routeService.getRoute(), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/route/delete/{id}")
    public ResponseEntity<String> deleteRouter(@PathVariable String id) {
        this.routeService.deleteRoute(id);
        return new ResponseEntity<>("Xoá thành công!", HttpStatus.OK);
    }
    
    @PutMapping("/route/update/{id}")
    public ResponseEntity<Route> updateUser(@PathVariable String id, @RequestBody Route updateRoute) {

        try {
            Route route = this.routeService.getRouteById(id);
            
            // PHẢI THAM CHIẾU NHƯ VẬY
            route.setNameRoute(updateRoute.getNameRoute());
            route.setStartingPointRoute(updateRoute.getStartingPointRoute());
            route.setDestinationRoute(updateRoute.getDestinationRoute());
            
            this.routeService.updateRoute(route);
            
            return new ResponseEntity<>(route, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
