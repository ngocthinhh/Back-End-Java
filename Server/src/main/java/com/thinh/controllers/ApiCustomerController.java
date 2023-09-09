/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.controllers;

import com.thinh.pojos.Customer;
import com.thinh.servicies.CustomerService;
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
public class ApiCustomerController {
    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        return new ResponseEntity<>(this.customerService.getCustomer(), HttpStatus.OK);
    }
    
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerByID(@PathVariable int id) {
        Customer customer = this.customerService.getCustomerById(id);

        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/customer/user/{id}")
    public ResponseEntity<Customer> getCustomerByUserID(@PathVariable int id) {
        Customer customer = this.customerService.getCustomerByUserId(id);

        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/customer/add")
    public ResponseEntity<List<Customer>> addCustomer(@RequestBody Customer newCustomer) {
        Customer customer = new Customer();
        customer = newCustomer;
        customer.setIdCustomer(-1);
        this.customerService.addCustomer(customer);

        return new ResponseEntity<>(this.customerService.getCustomer(), HttpStatus.CREATED);
    }
    
    @PutMapping("/customer/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer updateCustomer) {

        try {
            Customer customer = this.customerService.getCustomerById(id);

            // PHẢI THAM CHIẾU NHƯ VẬY
            customer.setFullNameCustomer(updateCustomer.getFullNameCustomer());
            customer.setEmailCustomer(updateCustomer.getEmailCustomer());
            customer.setPhoneNumberCustomer(updateCustomer.getPhoneNumberCustomer());
            customer.setIdUserCustomer(updateCustomer.getIdUserCustomer());

            this.customerService.updateCustomer(customer);

            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/customer/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
        this.customerService.deleteCustomer(id);
        return new ResponseEntity<>("Xoá thành công!", HttpStatus.OK);
    }
}
