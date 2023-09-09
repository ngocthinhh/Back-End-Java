/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.repositories;

import com.thinh.pojos.Payment;
import java.util.List;

/**
 *
 * @author Ngoc Thinh
 */
public interface PaymentRepository {
    List<Payment> getPayment();

    void addPayment(Payment payment);

    void deletePayment(int id);

    Payment getPaymentById(int id);

    void updatePayment(Payment payment);
    
    List<Payment> getPaymentByIdUser(int id);
}
