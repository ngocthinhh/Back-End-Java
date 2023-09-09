/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.servicies.Impl;

import com.thinh.pojos.Driver;
import com.thinh.repositories.DriverRepository;
import com.thinh.servicies.DriverService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ngoc Thinh
 */
@Service
public class DriverServiceImpl implements DriverService{
    @Autowired
    private DriverRepository driverRepository;

    @Override
    public List<Driver> getDriver() {
        return driverRepository.getDriver();
    }

    @Override
    public void addDriver(Driver driver) {
        driverRepository.addDriver(driver);
    }

    @Override
    public void deleteDriver(int id) {
        driverRepository.deleteDriver(id);
    }

    @Override
    public Driver getDriverById(int id) {
        return driverRepository.getDriverById(id);
    }

    @Override
    public void updateDriver(Driver driver) {
        driverRepository.updateDriver(driver);
    }
    
}
