/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.servicies;

import com.thinh.pojos.Customer;
import java.util.List;

/**
 *
 * @author Ngoc Thinh
 */
public interface CustomerService {
    List<Customer> getCustomer();

    void addCustomer(Customer customer);

    void deleteCustomer(int id);

    Customer getCustomerById(int id);
    
    Customer getCustomerByUserId(int id);

    void updateCustomer(Customer customer);
}
