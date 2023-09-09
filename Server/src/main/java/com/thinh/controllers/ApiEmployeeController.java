/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.controllers;

import com.thinh.pojos.Employee;
import com.thinh.servicies.EmployeeService;
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
public class ApiEmployeeController {
    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return new ResponseEntity<>(this.employeeService.getEmployee(), HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeByID(@PathVariable int id) {
        Employee employee = this.employeeService.getEmployeeById(id);

        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/employee/add")
    public ResponseEntity<List<Employee>> addEmployee(@RequestBody Employee newEmployee) {
        Employee employee = new Employee();
        employee = newEmployee;
        employee.setIdEmployee(-1);
        this.employeeService.addEmployee(employee);

        return new ResponseEntity<>(this.employeeService.getEmployee(), HttpStatus.CREATED);
    }

    @PutMapping("/employee/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee updateEmployee) {

        try {
            Employee employee = this.employeeService.getEmployeeById(id);

            // PHẢI THAM CHIẾU NHƯ VẬY
            employee.setFullNameEmployee(updateEmployee.getFullNameEmployee());
            employee.setEmailEmployee(updateEmployee.getEmailEmployee());
            employee.setPhoneNumberEmployee(updateEmployee.getPhoneNumberEmployee());
            employee.setIdUserEmployee(updateEmployee.getIdUserEmployee());

            this.employeeService.updateEmployee(employee);

            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/employee/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        this.employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Xoá thành công!", HttpStatus.OK);
    }
}
