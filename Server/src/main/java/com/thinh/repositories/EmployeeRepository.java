/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.repositories;

import com.thinh.pojos.Employee;
import java.util.List;

/**
 *
 * @author Ngoc Thinh
 */
public interface EmployeeRepository {
    List<Employee> getEmployee();

    void addEmployee(Employee employee);

    void deleteEmployee(int id);

    Employee getEmployeeById(int id);

    void updateEmployee(Employee employee);
}
