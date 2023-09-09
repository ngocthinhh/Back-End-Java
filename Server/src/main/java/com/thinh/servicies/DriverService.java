/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.servicies;

import com.thinh.pojos.Driver;
import java.util.List;

/**
 *
 * @author Ngoc Thinh
 */
public interface DriverService {
    List<Driver> getDriver();

    void addDriver(Driver driver);

    void deleteDriver(int id);

    Driver getDriverById(int id);

    void updateDriver(Driver driver);
}
