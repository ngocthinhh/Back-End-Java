/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.controllers;

import com.thinh.servicies.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Ngoc Thinh
 */
@Controller
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    
    // GET LIST
    @GetMapping("/listPayment")
    public String getAll(Model model) {
        model.addAttribute("payments", this.paymentService.getPayment());

        return "listPayment";
    }
    //
}
