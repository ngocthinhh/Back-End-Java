/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.thinh.repositories;

import com.thinh.pojos.Route;
import java.util.List;

/**
 *
 * @author Ngoc Thinh
 */
public interface RouteRepository {
    List<Route> getRoute();
    
    void addRoute(Route route);
    
    void deleteRoute(String id);
    
    Route getRouteById(String id);
    
    void updateRoute(Route route);
}
