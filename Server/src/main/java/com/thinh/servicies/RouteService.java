/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.thinh.servicies;

import com.thinh.pojos.Route;
import java.util.List;

/**
 *
 * @author Ngoc Thinh
 */
public interface RouteService {
    List<Route> getRoute();
    void addRoute(Route route);
    void deleteRoute(String id);
    Route getRouteById(String id);
    void updateRoute(Route route);
}
