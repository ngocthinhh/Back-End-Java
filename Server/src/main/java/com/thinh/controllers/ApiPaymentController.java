/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.controllers;

import com.thinh.pojos.Payment;
import com.thinh.servicies.PaymentService;
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
public class ApiPaymentController {
    @Autowired
    private PaymentService paymentService;
    
    @GetMapping("/payment")
    public ResponseEntity<List<Payment>> getAllPayment() {
        return new ResponseEntity<>(this.paymentService.getPayment(), HttpStatus.OK);
    }

    @GetMapping("/payment/{id}")
    public ResponseEntity<Payment> getPaymentByID(@PathVariable int id) {
        Payment payment = this.paymentService.getPaymentById(id);

        if (payment != null) {
            return new ResponseEntity<>(payment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/payment/add")
    public ResponseEntity<List<Payment>> addPayment(@RequestBody Payment newPayment) {
        Payment payment = new Payment();
        payment = newPayment;
        payment.setIdPayment(-1);
        this.paymentService.addPayment(payment);

        return new ResponseEntity<>(this.paymentService.getPayment(), HttpStatus.CREATED);
    }

    @PutMapping("/payment/update/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable int id, @RequestBody Payment updatePayment) {

        try {
            Payment payment = this.paymentService.getPaymentById(id);

            // PHẢI THAM CHIẾU NHƯ VẬY
            payment.setIdUserPayment(updatePayment.getIdUserPayment());
            payment.setIdReservationPayment(updatePayment.getIdReservationPayment());
            payment.setTimePayment(updatePayment.getTimePayment());
            payment.setTypePayment(updatePayment.getTypePayment());

            this.paymentService.updatePayment(payment);

            return new ResponseEntity<>(payment, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/payment/delete/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable int id) {
        this.paymentService.deletePayment(id);
        return new ResponseEntity<>("Xoá thành công!", HttpStatus.OK);
    }
    
    @GetMapping("/payment/user/{id}")
    public ResponseEntity<List<Payment>> getAllPaymentByIdUser(@PathVariable int id) {
        return new ResponseEntity<>(this.paymentService.getPaymentByIdUser(id), HttpStatus.OK);
    }
}
