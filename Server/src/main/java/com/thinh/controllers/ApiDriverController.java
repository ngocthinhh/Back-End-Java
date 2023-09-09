/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.controllers;

import com.thinh.pojos.Driver;
import com.thinh.servicies.DriverService;
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
public class ApiDriverController {
    @Autowired
    private DriverService driverService;
    
    @GetMapping("/driver")
    public ResponseEntity<List<Driver>> getAllDriver() {
        return new ResponseEntity<>(this.driverService.getDriver(), HttpStatus.OK);
    }
    
    @GetMapping("/driver/{id}")
    public ResponseEntity<Driver> getDriverByID(@PathVariable int id) {
        Driver driver = this.driverService.getDriverById(id);

        if (driver != null) {
            return new ResponseEntity<>(driver, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/driver/add")
    public ResponseEntity<List<Driver>> addCustomer(@RequestBody Driver newDriver) {
        Driver driver = new Driver();
        driver = newDriver;
        driver.setIdDriver(-1);
        this.driverService.addDriver(driver);

        return new ResponseEntity<>(this.driverService.getDriver(), HttpStatus.CREATED);
    }
    
    @PutMapping("/driver/update/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable int id, @RequestBody Driver updateDriver) {

        try {
            Driver driver = this.driverService.getDriverById(id);

            // PHẢI THAM CHIẾU NHƯ VẬY
            driver.setFullNameDriver(updateDriver.getFullNameDriver());
            driver.setEmailDriver(updateDriver.getEmailDriver());
            driver.setPhoneNumberDriver(updateDriver.getPhoneNumberDriver());
            driver.setIdUserDriver(updateDriver.getIdUserDriver());

            this.driverService.updateDriver(driver);

            return new ResponseEntity<>(driver, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/driver/delete/{id}")
    public ResponseEntity<String> deleteDriver(@PathVariable int id) {
        this.driverService.deleteDriver(id);
        return new ResponseEntity<>("Xoá thành công!", HttpStatus.OK);
    }
}
