/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.servicies.Impl;

import com.thinh.pojos.Payment;
import com.thinh.repositories.PaymentRepository;
import com.thinh.servicies.PaymentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ngoc Thinh
 */
@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentRepository paymentRepository;
    
    @Override
    public List<Payment> getPayment() {
        return this.paymentRepository.getPayment();
    }

    @Override
    public void addPayment(Payment payment) {
        this.paymentRepository.addPayment(payment);
    }

    @Override
    public void deletePayment(int id) {
        this.paymentRepository.deletePayment(id);
    }

    @Override
    public Payment getPaymentById(int id) {
        return this.paymentRepository.getPaymentById(id);
    }

    @Override
    public void updatePayment(Payment payment) {
        this.paymentRepository.updatePayment(payment);
    }

    @Override
    public List<Payment> getPaymentByIdUser(int id) {
        return this.paymentRepository.getPaymentByIdUser(id);
    }
    
}
