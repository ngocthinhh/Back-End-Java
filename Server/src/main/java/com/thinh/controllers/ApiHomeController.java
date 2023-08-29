/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.controllers;

import com.thinh.pojo.User;
import com.thinh.repositories.UserRepository;
import com.thinh.servicies.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ngoc Thinh
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class ApiHomeController {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/data")
    public String testApi()
    {
        return "API from NetBean";
    }
    
    @GetMapping("/dataUser")
    public List<User> testUser()
    {
        List<User> users = new ArrayList<>();
        
        User user = new User();
        user.setUsername("thinh");
        user.setPassword("123");
        
        User user2 = new User();
        user2.setUsername("duc");
        user2.setPassword("456");
        
        users.add(user);
        users.add(user2);
        
        return users;
    }
    
    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUser()
    {
        return new ResponseEntity<>(this.userService.getUser(), HttpStatus.OK);
    }
    
    @GetMapping("/add/user")
    public ResponseEntity<List<User>> addUser() {
        User user = new User();
        user.setId(-1);
        user.setUsername("ngocthinh");
        user.setPassword("333");
        this.userService.addOrUpdateUser(user);
        return new ResponseEntity<>(this.userService.getUser(), HttpStatus.OK);
    }
}
