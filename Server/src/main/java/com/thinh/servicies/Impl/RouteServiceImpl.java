/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.servicies.Impl;

import com.thinh.pojos.Route;
import com.thinh.repositories.RouteRepository;
import com.thinh.servicies.RouteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ngoc Thinh
 */
@Service
public class RouteServiceImpl implements RouteService{
    @Autowired
    private RouteRepository routeRepository;

    @Override
    public List<Route> getRoute() {
        return routeRepository.getRoute();
    }

    @Override
    public void addRoute(Route route) {
        routeRepository.addRoute(route);
    }

    @Override
    public void deleteRoute(String id) {
        routeRepository.deleteRoute(id);
    }

    @Override
    public Route getRouteById(String id) {
        return routeRepository.getRouteById(id);
    }

    @Override
    public void updateRoute(Route route) {
        routeRepository.updateRoute(route);
    }
}
